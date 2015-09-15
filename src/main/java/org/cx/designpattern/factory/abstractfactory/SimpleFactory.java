package org.cx.designpattern.factory.abstractfactory;

public class SimpleFactory extends Factory{

	@Override
	public Sample creator() {
		return new SampleA();
	}

	@Override
	public Sample2 creator(String name) {
		return new Sample2A();
	}


}



