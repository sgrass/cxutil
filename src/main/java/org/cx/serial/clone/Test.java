package org.cx.serial.clone;

import java.io.IOException;

/**
 * 浅拷贝：被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。
 * 浅拷贝仅仅复制所拷贝的对象，而不复制它所引用的对象。
 *
 * 深拷贝：被复制对象的所有变量都含有与原来的对象相同的值，除去那些引用其他对象的变量。
 * 那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。
 * 深拷贝把要复制的对象所引用的对象都复制了一遍
 *
 * @author grass
 * @date 2017/10/29
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher=new Teacher();
        teacher.setName("teac");

        Student student=new Student();
        student.setName("stuuuu");
        student.setId(18);
        student.setTeacher(teacher);

        Student student2=(Student) student.deepClone(); //深克隆一个对象
        System.out.println(student);

        student2.getTeacher().setName("hello");
        System.out.println(student2);

    }
}
