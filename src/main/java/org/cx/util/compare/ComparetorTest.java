package org.cx.util.compare;

import java.util.Comparator;

public class ComparetorTest implements Comparator<Student> {
	

	public int compare(Student o1, Student o2) {
		//如果o1.age > o2.age，方法返回正数，为正数正是表明哦o1 > o2
    //如果o1.age = o2.age，方法返回0，返回0正是表明o1 == o1
    //如果o1.age < o2.age，方法返回正数，为负数正是表明哦o1 < o2
		return o1.getId()-o2.getId();
	}
}
