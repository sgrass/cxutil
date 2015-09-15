package org.cx.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsTest  extends AA {

	public static <T> void fromArrayToConnection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o);
		}
	}
	
	@SuppressWarnings("unused")	
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		List<?> lo = ls;
		ls.add("111");
//		lo.add("");
		String s = (String) lo.get(0);
//		System.out.println(s);
		
		Object oa[] = new Object[]{"aa",11};
		Collection<Object> co = new ArrayList<Object>();
		fromArrayToConnection(oa, co);
		for (Object o : co) {
//			System.out.println(o);
		}
		
		String str[] = new String[]{"str1","str2"};
		Collection<String> cs = new ArrayList<String>();
		fromArrayToConnection(str, cs);
		fromArrayToConnection(str, co);
		for (Object o : co) {
//			System.out.println(o);
		}
		
		Integer i[] = new Integer[]{100,200};
		Collection<Integer> ci = new ArrayList<Integer>();
		fromArrayToConnection(i, ci);
		fromArrayToConnection(i, co);
		for (Object o : co) {
			System.out.println(o);
		}
		
		List<List<? extends AA>> aaa = new ArrayList<List<? extends AA>>();
		List<GenericsTest> list = new ArrayList<GenericsTest>();
		list.add(new GenericsTest());
		aaa.add(list);
	}

}
