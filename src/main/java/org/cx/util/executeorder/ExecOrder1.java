package org.cx.util.executeorder;


class Demo {
	{
		System.out.println("structure....");
	}
	static {
		System.out.println("demo static lump...");
	}
	public Demo() {
		System.out.println("structure function...");
	}
}


public class ExecOrder1 {
	static {
		System.out.println("static lump...");
	}
	
	public static void main(String[] args) {
		new Demo();
	}
}
