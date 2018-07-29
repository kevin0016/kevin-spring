package com.itkevin.delegate.test;

public class Dispacher implements IExector {
    IExector exector;
    Dispacher(IExector exector){
        this.exector = exector;
    }
    /**
     * 虽然也有执行方法
     * 但是工作职责是不一样的
     */
    @Override
    public void doing() {
        exector.doing();
    }
}
