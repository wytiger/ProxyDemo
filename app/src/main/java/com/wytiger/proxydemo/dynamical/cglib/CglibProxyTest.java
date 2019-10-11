package com.wytiger.proxydemo.dynamical.cglib;

import com.wytiger.proxydemo.Shopping;
import com.wytiger.proxydemo.statical.ShoppingImpl;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/10/9 0009 15:59
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        //通过动态生成子类的方式创建代理类
        Shopping proxy = (Shopping) cglibProxy.getProxy(ShoppingImpl.class);
        proxy.doShopping(500);
    }
}
