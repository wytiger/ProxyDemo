package com.wytiger.proxydemo.dynamical.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/10/9 0009 15:58
 */
public class CglibProxy implements MethodInterceptor {

    Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        //目标方法前执行
        System.out.println("——————————————————————————");
        System.out.println("出门买东西");
        //目标方法调用
        Object result = proxy.invokeSuper(obj, args);
        //目标方法后执行
        System.out.println("买完回家");
        return result;
    }
}
