package com.wytiger.proxydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wytiger.proxydemo.dynamical.jdk.MyInvocationHandler;
import com.wytiger.proxydemo.statical.ProxyShopping;
import com.wytiger.proxydemo.statical.ShoppingImpl;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shopping myself = new ShoppingImpl();
                ProxyShopping proxy = new ProxyShopping(myself);
                proxy.doShopping(100);
            }
        });
        findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shopping myself = new ShoppingImpl();
                MyInvocationHandler handler = new MyInvocationHandler(myself);
                Shopping proxy = (Shopping) Proxy.newProxyInstance(
                        myself.getClass().getClassLoader(),//目标类的类加载器
                        myself.getClass().getInterfaces(),//目标类的接口
                        handler);//处理类
                proxy.doShopping(200);
            }
        });
        findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cglib不能在android中使用
//                CglibProxy cglibProxy = new CglibProxy();
//                Shopping proxy = (Shopping) cglibProxy.getProxy(ShoppingImpl.class);
//                proxy.doShopping(500);
            }
        });
    }
}
