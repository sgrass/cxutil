package org.cx.designpattern.factory;

public class BaoMaDriver implements Driver {
	
	public Car driveCar() {
		return new BaoMaCar();
	}
}
