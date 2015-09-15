package org.cx.util.executeorder;

/**
 * 初始化顺序
 * 当new MyInit2()时：
 * 父类静态成员变量或对象、静态块的初始化=>子类静态成员变量或对象、静态块的初始化
 * =>父类非静态成员变量或对象的初始化=>父类构造函数的执行
 * =>子类非静态成员变量或对象的初始化=>子类构造函数的执行
 *
 * static静态成员变量或对象、静态块优先初始化，且（在同一新开辟的内存中）只执行一次
 */
public class MyInit2 extends Super2 {
  static String str = getMstr();
  static String getMstr() {
    System.out.println("1");
    return "str";
  }

  static {
    System.out.println("2");
  }

  int n = getMn();
  int getMn() {
    System.out.println("3");
    return 10;
  }

  MyInit2() {
    System.out.println("4");
  }

  public static void main(String args[]) {
    Super2 objs = new MyInit2();
    MyInit2 objm = new MyInit2(); //static静态成员变量或对象、静态块优先初始化，且（在同一新开辟的内存中）只执行一次
  }
}

class Super2 {
  static String str = getSstr();
  static String getSstr() {
    System.out.println("5");
    return "str";
  }

  static {
    System.out.println("6");
  }

  int n = getSn();
  int getSn() {
    System.out.println("7");
    return 10;
  }

  Super2() {
    System.out.println("8");
  }
}
