package com.wytiger.proxydemo.statical;

import com.wytiger.proxydemo.Shopping;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/10/9 0009 15:27
 */
public class ProxyShopping implements Shopping {
    Shopping base;

    public ProxyShopping(Shopping base) {
        this.base = base;
    }

    @Override
    public Object[] doShopping(long money) {
        System.out.println(String.format("代理花了%s块钱", money));

        // 先黑点钱(修改输入参数)
        long readCost = (long) (money * 0.5);

        // 帮忙买东西
        Object[] things = base.doShopping(readCost);

        // 再黑点东西(修改返回值)
        if (things != null && things.length > 1) {
            things[0] = "矿泉水";
        }

        return things;
    }
}
