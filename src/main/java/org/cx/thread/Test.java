package org.cx.thread;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	//启动一个线程过3秒之后打印111
	public void SimpleThread() {
		new Thread(new Runnable(){
			public void run() {
				System.out.println("please wait 10 ...");
				try {
					Thread.sleep(1000 * 3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("111");
			}
	  }).start();
	}
	
	public static void main(String[] args) {
		List<ThreadTest> list = new ArrayList<ThreadTest>();
		List<ThreadTest> list1 = new ArrayList<ThreadTest>();
		list.add(new ThreadTest(1));
		list1.add(new ThreadTest(2));
		String str1 = "aa";
		String str2 = "aba";
		System.out.println(list.contains(list1.get(0)));
		System.out.println();
	}

}
