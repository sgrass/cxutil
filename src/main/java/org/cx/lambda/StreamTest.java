package org.cx.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void mapTest() {
		//转换为大写
		List<String> list = Stream.of("a","helllo","c","d").map(string -> string.toUpperCase()).collect(Collectors.toList());
		
		list.stream().forEach(str -> System.out.println(str));
		
	}
	
	public static void listLoop() {
		List<String> list = Stream.of("aaa","bbb","3ccc","4ddd","eee","fff").collect(Collectors.toList());
		System.out.println(list.stream().count());
		
		//找出以数字开头的字符串
		List<String> withNumber = list.stream().filter(value -> Character.isDigit(value.charAt(0))).collect(Collectors.toList());
		withNumber.stream().forEach(str -> System.out.println(str));
		
		//flatMap合并两个list
		List<Integer> together = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4,5)).flatMap(numbers -> numbers.stream()).collect(Collectors.toList());
		together.stream().forEach(str -> System.out.println(str));
		
		
		/**
		 * 找出价钱最便宜的手机对象
		 * java8提供新的方法comparing，方便的实现一个比较器，这个方法接受一个函数并返回另一个函数
		 */
		List<Mobile> mobileList = Arrays.asList(new Mobile("samsung", 4000),new Mobile("apple", 6000));
		Mobile mobile = mobileList.stream().min(Comparator.comparing(mob -> mob.getPrice())).get();
		System.out.println(mobile.toString());
		
		
		Set<Integer> number = new HashSet<Integer>(Arrays.asList(4,3,5,2,1));
		List<Integer> sortNumber = number.stream().sorted().collect(Collectors.toList());
		sortNumber.stream().forEach(str -> System.out.println(str));
	}
	
	
	public static void reduceTest() {
		//累加
		int count = Stream.of(1,2,3).reduce(0, (acc,element)->acc+element);
		System.out.println(count);
	}
	
	
	public static void main(String[] args) {
		listLoop();
//		mapTest();
//		reduceTest();
	}

}
