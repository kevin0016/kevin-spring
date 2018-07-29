package com.itkevin.singleton.test;

/**
 * 采用静态内部类的方式  lazy loading比较常用的方式
 * 　　这种方式同样利用了classloader的机制来保证初始化instance时只有一个线程，
 * 它跟第三种和第四种方式细微的差别是前两种是只要Singleton类被装载了，那么instance
 * 就会被实例化，也就没有达到lazy loading效果，而这种方式是Singleton类被装载了，
 * instance不一定被初始化。因为SingleHolder类没有被主动使用，只有显示通过调用getInstance方法时
 * 才会显示装载SingleHolder类，从而实例化instance。想象一下，如果实例化instance很消耗资源，我想
 * 让他延迟加载，另外一方面，我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能
 * 在其他的地方被主动使用从而被加载，那么这个时候实例化instance显然是不合适的。这个时候，这种方式相
 * 比第三和第四种方式就显得很合理。
 */
public class Singleton5 {
    private static class SingletonHolder{
        private static final Singleton5 INSTSNCE = new Singleton5();
    }
    private Singleton5 () {}
    public static final Singleton5 getInstance () {
        return SingletonHolder.INSTSNCE;
    }
}
