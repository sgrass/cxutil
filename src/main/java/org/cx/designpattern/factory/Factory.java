package org.cx.designpattern.factory;

/**
 * 工厂方法模式(factory method)
        如果是一部车对应一个司机的话，可先要叫得这个司机，然后再去取车子
 * @author caoxiao
 * @create date 2011-5-13
 */
public class Factory {
	
	public static void main(String[] args) {
		 Driver dirver = new QQDriver();  
     Car car = dirver.driveCar();  
     car.drive(); 
	}
}
