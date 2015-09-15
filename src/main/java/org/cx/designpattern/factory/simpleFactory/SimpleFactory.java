package org.cx.designpattern.factory.simpleFactory;

/**
 * 简单工厂模式(simple factory)
       也叫静态工厂模式,一般是具体产品的继承类或者是接口的实现，如下一个司机开多种车的例子。
 * @author caoxiao
 * @create date 2011-5-13
 */
public class SimpleFactory {
	
	public static Car getCar(String carname) {
		if (carname.equalsIgnoreCase("QQCar")) {
			return new QQCar();
		} else if (carname.equalsIgnoreCase("BaoMaCar")) {
			return new BaoMaCar();
		} else if (carname.equalsIgnoreCase("BenChiCar")) {
			return new BenChiCar();
		}
		return null;
	}

	public static void main(String[] args) {
		
		Car car = SimpleFactory.getCar("QQCAR");
		car.drive();
		
	}
	
}
