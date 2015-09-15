package org.cx.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

class Student {
	private int id;
	private String name;
	private List address;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getAddress() {
		return address;
	}
	public void setAddress(List address) {
		this.address = address;
	}
}

class Teacher {
	private int teacId;
	private Student stu;
	
	public int getTeacId() {
		return teacId;
	}
	public void setTeacId(int teacId) {
		this.teacId = teacId;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
}

/**
 * @author cx
 * @date 2010-04-22
 * Xstream操作对象到xml或从xml读到对象
 * 需要xstream-1.3.1.jar
 */
public class Xstream {

	public static void main(String[] args) {
		XStream sm = new XStream();  
		
		Teacher teac = new Teacher();
		//把对象写成xml
		Student t = new Student();  
		t.setId(11);
		t.setName("阿斯顿撒");
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		t.setAddress(list);
		
		teac.setTeacId(22);
		teac.setStu(t);
		try {  
		FileOutputStream ops = new FileOutputStream(new File("D:\\aa.xml"));
		sm.alias("aa", Student.class);
		sm.toXML(teac, ops);  
		ops.close();  
		} catch (Exception e) {  
		    e.printStackTrace();  
		}
		
		//随便写对象到xml
//		try {
//			List<String> list = new ArrayList<String>();
//			FileOutputStream fout = new FileOutputStream("D:\\aa.xml");
//			ObjectOutputStream out = sm.createObjectOutputStream(fout);
//			
//			list.add("aaa");
//			list.add("bbb");
//			out.writeObject("hello");
//			out.writeObject(list);
//			out.writeInt(12345);
//	
//			out.close();
//		} catch (Exception e) {
//		}
		//读随便写的xml
//		 try {
//			FileInputStream fin = new FileInputStream("D:\\aa.xml");
//		  ObjectInputStream in = sm.createObjectInputStream(fin);
//		  String aa = (String) in.readObject();
//		  List bb = (List) in.readObject();
//		  System.out.println(aa+bb);
//		 } catch (Exception e) {
//    	 e.printStackTrace();
//		 }  
		 
		//读xml到对象
//     try {
//	     FileInputStream fin = new FileInputStream("D:\\aa.xml");   
//	     sm.aliasType("aa",Student.class);
//	     Teacher t = (Teacher)sm.fromXML(fin);
//	     System.out.println(t.getTeacId()+t.getStu().getAddress());
//	     fin.close();   
//	   } catch (Exception e) {
//	    	 e.printStackTrace();
//	   }       
	   
	}
}
