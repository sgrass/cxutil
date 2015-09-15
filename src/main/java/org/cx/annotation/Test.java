package org.cx.annotation;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/**
 * 读取annotation内容
 * @author caoxiao
 *
 */
public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		try {
			Class testClass = Class.forName("org.cx.annotation.Temp");
			Method methodName = testClass.getMethod("display", String.class);
			MyAnnotation ma = methodName.getAnnotation(MyAnnotation.class);
			System.out.println(ma.key());
			System.out.println(ma.value());
			System.out.println(methodName.getName());
			
			Object obj = testClass.newInstance();
			methodName.invoke(obj, "哈哈哈");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
