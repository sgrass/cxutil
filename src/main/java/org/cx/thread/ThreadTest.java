package org.cx.thread;

public class ThreadTest extends Thread {

	private int threadNo;

	public ThreadTest(int threadNo) {
		this.threadNo = threadNo;
	}
	
	//同步保持方法完整的执行完毕再执行下一次调用
	public static synchronized void display() {
		for (int i=0; i<100; i++) {
			System.out.print(i);
		}
		System.out.println();
	}
	
	public  void run() {
		display();
	} 
	
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			new ThreadTest(i).start();
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
