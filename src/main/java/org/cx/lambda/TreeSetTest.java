package org.cx.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeSetTest {
	public static void main(String[] args) {

		 Map<String, String> map = new TreeMap<String, String>();
		 map.put("nickName", "babc");
		 map.put("headImg", "aacb");
		 map.put("uid", "qf4s");
		 map.put("origin", "145");
		 map.forEach((k,v) ->System.out.println(k+"---"+v));
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		// numbers.forEach(value -> System.out.println(value));

		numbers.forEach(System.out::println);

		new Thread(() -> System.out.println("Hello world !")).start();

		List<Person> pList = new ArrayList<Person>() {
			{
				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
				add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
				add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
				add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
				add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
				add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
				add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
				add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
				add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
				add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			}
		};

//		pList.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
		
		pList.stream().filter(p -> (p.getSalary() > 1500)).forEach(p -> System.out.println(p.getSalary()));
		
		
	}
}

class Person {

	private String firstName, lastName, job, gender;
	private int salary, age;

	public Person(String firstName, String lastName, String job, String gender, int age, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.job = job;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}