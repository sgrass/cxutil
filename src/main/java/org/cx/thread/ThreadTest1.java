package org.cx.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest1 implements Runnable {

	class Student {
		private int age = 0;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

	Student student = new Student();
	int count = 0;
	
	//重入锁
	ReentrantLock lock1 = new ReentrantLock(false);
	ReentrantLock lock2 = new ReentrantLock(false);
	
	public void run() {
		accessStudent();
	}

	public void accessStudent() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");
		lock1.lock();//使用重入锁 或者synchronized(this)块,同步块会自动释放锁，重入锁需手动释放
		System.out.println(currentThreadName + " got lock1@Step1!");
		try {
			count++;
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(currentThreadName + " first Reading count:" + count);
			lock1.unlock();
			System.out.println(currentThreadName + " release lock1@Step1!");
		}

		lock2.lock();
		System.out.println(currentThreadName + " got lock2@Step2!");
		try {
			Random random = new Random();
			int age = random.nextInt(100);
			System.out.println("thread " + currentThreadName + " set age to:" + age);

			this.student.setAge(age);

			System.out.println("thread " + currentThreadName + " first  read age is:" + this.student.getAge());

			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("thread " + currentThreadName + " second read age is:" + this.student.getAge());
			lock2.unlock();
			System.out.println(currentThreadName + " release lock2@Step2!");
		}
	}

	public static void main(String[] args) {
		ThreadTest1 td = new ThreadTest1();
    Thread t1 = new Thread(td, "a");
    Thread t2 = new Thread(td, "b");
    Thread t3 = new Thread(td, "c");
    t1.start();
    t2.start();
    t3.start();
	}

}
