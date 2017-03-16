package org.cx.util.compare;


/**
 * compareTo(Object o)方法是java.lang.Comparable<T>接口中的方法，当需要对某个类的对象进行排序时，该类需要实现Comparable<T>接口的，
 * 	必须重写public int compareTo(T o)方法，比如MapReduce中Map函数和Reduce函数处理的 <key,value>,其中需要根据key对键值对进行排序，
 * 	所以，key实现了WritableComparable<T>接口，实现这个接口可同时用于序列化和反序列化。
 * WritableComparable<T>接口(用于序列化和反序列化)是Writable接口和Comparable<T>接口的组合；
 * 
 * compare(Object o1,Object o2)方法是java.util.Comparator<T>接口的方法，它实际上用的是待比较对象的compareTo(Object o)方法。
 * @author grass
 *
 */
public class Student implements Comparable<Object> {
	
	private int id;
	
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

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

	/**
	 * 通过 x.compareTo(y) 来“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
	 * 
	 * 简单的写法return this.id-o.id
	 */
	public int compareTo(Object o) {
		if (this == o) {
			return 0;
		} else if (o != null && o instanceof Student) {
			Student u = (Student) o;
			if (id <= u.id) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return -1;
		}
	}
}
