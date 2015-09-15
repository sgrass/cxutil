package org.cx.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * 集合操作相关方法
 * @author cx
 * @create date Aug 12, 2010
 */
public class TestUtil {

  
	/**
	 * 数组合并，然后排序
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static int[] arrayUnion(int arr1[], int arr2[]) {
		int arr3[] = new int[arr1.length+arr2.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		Arrays.sort(arr3);
		for(int i:arr3) {
			System.out.println(i);
		}
		return arr3;
	}
	
	//...为参数可传单个或者数组
	public static void display(int ... arg) {
		for (int x:arg) {
			System.out.println(x);
		}
	}
	
	/**
	 * 数组转换为list，然后合并list 排序
	 * @param args
	 */
	public void arrayToListUnion(String[] args) {
	  String[] str1 = {"A","B","C","D","E","F","G","A"};   
	  String[] str2 = {"a","C","D","E","F","G","H","I","H","I"};   
	  List<String> l1 = new ArrayList<String>(Arrays.asList(str1));   
	  List<String> l2 = new ArrayList<String>(Arrays.asList(str2));
	  System.out.println(l1.retainAll(l2));
	  Arrays.sort(str1);
	  for(String str:str1) {
	  	System.out.println(str);
	  }
	  System.out.println(str1[0].compareTo(str2[0]));
		
	}
	
	/**
	 * treeMap默认按照升序排序
	 */
	public static void sortTreeMap() {
		Map tmp=new TreeMap();
		tmp.put("1", "aaa");
		tmp.put("2", "bbb");
		tmp.put("4", "ddd");
		tmp.put("3", "ccc");
		
		Iterator it = tmp.entrySet().iterator();   
		while (it.hasNext())    
		{   
			Map.Entry pairs = (Map.Entry)it.next();   
		  System.out.println(pairs.getKey() + " = " + pairs.getValue());   
		}  
		
	}
	
	public static void main(String[] args) {
//		int arr1[] = {9,8,7,6,5};
//		int arr2[] = {10,9,7,6,5};
//		arrayUnion(arr1, arr2);
		
//		display(arr1);
		
//		sortTreeMap();
		
	}

}
