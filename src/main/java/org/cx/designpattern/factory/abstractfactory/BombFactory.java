package org.cx.designpattern.factory.abstractfactory;

public class BombFactory extends Factory {

	public Sample creator() {
		return new SampleB();
	}

	public Sample2 creator(String name) {
		return new Sample2B();
	}

}
