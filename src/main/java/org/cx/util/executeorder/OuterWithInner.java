package org.cx.util.executeorder;

/**
 * 非静态内部类可以有静态常量
 * @author caoxiao
 *
 */
public class OuterWithInner {
	
	class InnerClass{  
	  private static  final int i = 1;  
	} 
	
	public static void main(String[] args) {
		System.out.println(InnerClass.i);
	}
}
