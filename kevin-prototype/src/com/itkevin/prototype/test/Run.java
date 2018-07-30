package com.itkevin.prototype.test;

import com.itkevin.prototype.test.greatestsage.TheGreatestSage;
import com.itkevin.prototype.test.simple.ConcreatePrototype;
import org.junit.Test;

/**
 * 原型模式
 * 过程相同，结果不同
 */
public class Run {

    @Test
    public void test1(){
        ConcreatePrototype cp = new ConcreatePrototype();
        cp.setAge(123);
       /* try {

            ConcreatePrototype clone = (ConcreatePrototype) cp.clone();
            System.out.println(clone.getAge());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/

        //就是有一个现成的对象，这个对象里面有已经设置好的值
        //当我们要新建的对象，并且要给新建的对象赋值，而且赋值内容要跟之前的一模一样
        //原理：用循环，用反射，确实可以，但是性能并不高
        //字节码复制newInstance
        //
        //深度拷贝，通过实现Cloneable接口，重写clone方法的方式进行拷贝（针对非基本类型的属性进行单独clone）
        //浅度拷贝,能够直接拷贝其实际内容的数据类型只支持9种，就是Java的八大基本数据类型+String

    }



    @Test
    public void test2(){
        TheGreatestSage theGreatestSage = new TheGreatestSage();
        theGreatestSage.change();
    }
}
