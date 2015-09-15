package org.cx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void getConstructorMethod() {
		try {
			Class cls = Class.forName("org.cx.reflect.Student");
	    Constructor ctorlist[] = cls.getDeclaredConstructors();
	    for (int i = 0; i < ctorlist.length; i++) {
	    	Constructor ct = ctorlist[i];
		    System.out.println("package=" + ct.getDeclaringClass()+" name=" + ct.getName());
		    Class pvec[] = ct.getParameterTypes();
		    for (int j = 0; j < pvec.length; j++)
		        System.out.println("param #" + j + " " + pvec[j]);
		    Class evec[] = ct.getExceptionTypes();
		    for (int j = 0; j < evec.length; j++)
		        System.out.println("exc #" + j + " " + evec[j]);
		    System.out.println("-----");
	    }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifier,也是一个 reflection 类，用来描述字段成员的修饰语,
	 * 如"private int"。这些修饰语自身由整数描述,
	 * 而且使用 Modifier.toString 来返回以"官方"顺序排列的字符串描述 (如"static"在"final"之前)
	 */
	public static void getFiled() {
	  try {
      Class cls = Class.forName("org.cx.reflect.Student");
      Field fieldlist[] = cls.getDeclaredFields();
      for (int i = 0; i < fieldlist.length; i++) {
          Field fld = fieldlist[i];
          System.out.println("package=" + fld.getDeclaringClass());
          int mod = fld.getModifiers();
          System.out.print("modifiers=" + Modifier.toString(mod));
          System.out.print("\t type=" + fld.getType());
          System.out.print("\t name=" + fld.getName());
          System.out.println();
      }
	  } catch (Throwable e) {
	      System.err.println(e);
	  }
	}
	
	public static void getDeclaredMethod() {
		try {
			Class c = Class.forName("org.cx.reflect.Student");
	    Method method[] = c.getDeclaredMethods();
	    for (int i = 0; i < method.length; i++) {
	    	Method m = method[i];
	    	System.out.println(method[i].toString());
	    	System.out.println("package:"+method[i].getDeclaringClass()+" method Name:"+method[i].getName());
	    	Class pvec[] = m.getParameterTypes();
	    	for (int j = 0; j < pvec.length; j++)
          System.out.println("Parameter--" + j + " " + pvec[j]);
	    	Class evec[] = m.getExceptionTypes();
        for (int j = 0; j < evec.length; j++)
            System.out.println("exception---" + j + " " + evec[j]);
        System.out.println("return type = " + m.getReturnType());
        System.out.println();
	    }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void getMethodByName() {
		try {
			Class cls = Class.forName("org.cx.reflect.Student");
      Class partypes[] = new Class[2];
      partypes[0] = Integer.TYPE;
      partypes[1] = Integer.TYPE;
      Method meth = cls.getMethod("add", partypes);
      
      Student stu = new Student();
      Object arglist[] = new Object[2];
      arglist[0] = new Integer(10);
      arglist[1] = new Integer(8);
      Object retobj = meth.invoke(stu, arglist);
      Integer retval = (Integer) retobj;
      System.out.println(retval.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void getMethodByName2() {
		try {
			Class cls = Class.forName("org.cx.reflect.Student");
			Object obj = cls.newInstance();
			Method method = cls.getMethod("welcomeStu", int.class,String.class);
			method.invoke(obj, 11,"aa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			Class cls = Class.forName("org.cx.reflect.Student");
//			Object obj = cls.newInstance();
//			Method method = cls.getMethod("setId",int.class);
//			method.invoke(obj, 22);
//			
//			Method getMethodValue = cls.getMethod("getId");
//			System.out.println(getMethodValue.invoke(obj));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 对于构造器，则不能像执行方法那样进行，
	 * 因为执行一个构造器就意味着创建了一个新的对象 (准确的说，创建一个对象的过程包括分配内存和构造对象)
	 */
	public static void getConstructorByName() {
		try {
			Class cls = Class.forName("org.cx.reflect.Student");
      Class partypes[] = new Class[2];
      partypes[0] = Integer.TYPE;
      partypes[1] = String.class;
      Constructor ct = cls.getConstructor(partypes);
      Object arglist[] = new Object[2];
      arglist[0] = new Integer(37);
      arglist[1] = new String("luxi");
      Object retobj = ct.newInstance(arglist);
      Student stu = (Student) retobj;
      stu.welcomeStu(1, "123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置公有变量 以及获取
	 */
	public static void setFiledByName() {
		try {
			Class cls = Class.forName("org.cx.reflect.Student");
	    Field fld = cls.getField("address");
	    Student stu = new Student();
	    System.out.println("原来的id = " + stu.address);
	    fld.set(stu, "bb");
	    System.out.println("设置后id = " + fld.get(stu));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			Class cls = Class.forName("org.cx.reflect.Student");
//			Object obj = cls.newInstance();
//			Field field = cls.getDeclaredField("list");
//			List<String> list = (List<String>) field.get(obj);
//			list.add("aa");
//			list.add("bb");
//			System.out.println(((List<String>)field.get(obj)).size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 设置私有变量  以及获取
	 */
	public static void setPrivateFiledByName() {
		try {
			Class cls = Class.forName("org.cx.reflect.Student");
			Object obj = cls.newInstance();
      Field field = cls.getDeclaredField("id");
      field.setAccessible(true);
      field.set(obj, 2);
      System.out.println(field.get(obj));
      
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)  {
//		getConstructorMethod();
//		getFiled();
//		getDeclaredMethod();
//		getMethodByName();
//		getMethodByName2();
//		getConstructorByName();
//		setFiledByName();
//		setPrivateFiledByName();
		
	}

}
