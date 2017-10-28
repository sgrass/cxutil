package org.cx.thread.threadlocal;

import java.lang.ref.WeakReference;

/**
 * @author grass
 * @date 2017/10/28
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        Person person = new Person(18,"grass");

        //弱引用
        WeakReference<Person> weakReference = new WeakReference<Person>(person);

        while (true) {
            Person p= weakReference.get();
            if (p != null) {
                System.out.printf("对象存在...%s \n", weakReference);
            } else {
                System.out.printf("对象被回收");
                break;
            }
        }
    }
}

class Person {
    private Integer id;

    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
