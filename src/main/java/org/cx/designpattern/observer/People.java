package org.cx.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author grass
 * @date 2017/11/18
 */
public class People implements Observer {

    private String name;

    public People(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object data) {
        System.out.printf("将观察者->: %s 的价格 price 更新 %s \n", this.name, data);
    }

    public static void main(String[] args) {
        /**
         * 缺点：
         *  1、Vector作为底层存储(全线程安全的)
         *  2、没有支持泛型
         *  3、同步->阻塞
         */
        Antique house = new Antique(111);
        People p1 = new People("p1");
        People p2 = new People("p2");
        People p3 = new People("p3");

        //增加观察者
        house.addObserver(p1);
        house.addObserver(p2);
        house.addObserver(p3);

        System.out.printf("古董价格是:%s\n",house);
        house.setPrice(222);

        System.out.printf("古董价格是:%s\n",house);

    }

}
