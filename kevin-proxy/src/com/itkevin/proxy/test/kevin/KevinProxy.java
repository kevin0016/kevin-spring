package com.itkevin.proxy.test.kevin;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 创建自己的代理方法，
 */
public class KevinProxy {
    private static String ln = "\r\n";

    public static Object newProxyInstance(KevinClassloader classLoader,Class<?>[] interfaces,KevinInvocationHandler h){
        try {
            //1、生成源代码
            String proxySrc = generateSrc(interfaces[0]);

            //2、讲生成的源代码输出到磁盘，保存为.JAVA文件
            String path = KevinProxy.class.getResource("").getPath();
            File file = new File(path+"$Proxy.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(proxySrc);
            fileWriter.flush();
            fileWriter.close();

            //3、编译源代码，并生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            //4、讲class文件中的内容动态加载到JVM中来
            //5、返回被代理后的对象
            Class proxyClass = classLoader.findClass("$Proxy"); //找到代理类
            Constructor constructor = proxyClass.getConstructor(KevinInvocationHandler.class);//返回构造器
            file.delete();//删除.JAVA文件
            return constructor.newInstance(h);


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




    private static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.gupaoedu.vip.custom;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);

        src.append("GPInvocationHandler h;" + ln);

        src.append("public $Proxy0(GPInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}");

        return src.toString();
    }

}
