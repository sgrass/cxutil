package org.cx.designpattern.factory.abstractfactory;

public class TestFactory {

	public static void main(String[] args) {
		Sample s = new SimpleFactory().creator();
		s.print();
		Sample2 sb = new SimpleFactory().creator("aa");
		sb.print();
	}

}
