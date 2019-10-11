package com.wytiger.proxydemo.dynamical.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/10/9 0009 15:37
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public  MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("——————————————————————————");
        System.out.println("方法执行前");

        //目标方法调用
        Object obj = method.invoke(target, args);

        System.out.println("方法执行后");
        return obj;
    }
}
