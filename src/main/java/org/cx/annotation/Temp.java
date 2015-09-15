package org.cx.annotation;


public class Temp {
	
	@MyAnnotation(key="aaa",value = "bbb")
	public static void display(String str) {
		System.out.println("到这里"+str);
	}
	
}
