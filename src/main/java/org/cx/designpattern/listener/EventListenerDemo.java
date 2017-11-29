package org.cx.designpattern.listener;

import java.beans.PropertyChangeSupport;

/**
 * 事件监听模式
 * {@link java.util.EventObject} 标准事件对象
 * {@link java.util.EventListener} 标准事件监听对象
 *
 * @author grass
 * @date 2017/11/19
 */
public class EventListenerDemo {
    public static void main(String[] args) {
        /**
         * java beans 规范 --> 内省
         * PropertyChaganeEvent -->广播源
         * propertyChangeListener -->注册器
         */

        Student student = new Student();
        PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(student);

        //注册
        propertyChangeSupport.addPropertyChangeListener("name", (event) -> {
            Student bean = (Student) event.getSource();

            System.out.printf("Person[%s] 的name属性，旧值:%s， 新值:%s", bean, event.getOldValue(), event.getNewValue());

        });

        //触发事件
        propertyChangeSupport.firePropertyChange("name", null, "hello world");


    }

    public static class Student {
        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
