package com.wytiger.proxydemo.statical;

import com.wytiger.proxydemo.Shopping;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/10/9 0009 15:26
 */
public class ShoppingImpl implements Shopping {
    @Override
    public Object[] doShopping(long money) {
        System.out.println("逛淘宝 ,逛商场,买买买!!");
        System.out.println(String.format("花了%s块钱", money));
        return new Object[] { "鞋子", "衣服", "包包" };
    }
}
