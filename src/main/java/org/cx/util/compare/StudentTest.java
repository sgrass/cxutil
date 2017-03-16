package org.cx.util.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentTest {

	// 编写Comparator,根据User的id对User进行排序
	private static final Comparator<Student> COMPARATOR = new Comparator<Student>() {
		public int compare(Student o1, Student o2) {
			return o1.compareTo(o2);// 运用User类的compareTo方法比较两个对象
		}
	};

	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		Student user1 = new Student(9, "哇哈哈");
		Student user2 = new Student(2, "金丝猴");
		list.add(user1);
		list.add(user2);
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}
		
	}
}
