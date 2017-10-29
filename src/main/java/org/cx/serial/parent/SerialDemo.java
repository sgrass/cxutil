package org.cx.serial.parent;

import org.cx.serial.simple.Person;

import java.io.*;

/**
 * 子类实现序列化 父类不实现 父类中的成员不会被序列化
 * 父类实现序列化，子类默认序列化
 *
 * @author grass
 * @date 2017/10/29
 */
public class SerialDemo {

    public static void main(String[] args) {

        serializeStudent();

        Student student = deSerializeStudent();
        System.out.println(student);
    }

    private static void serializeStudent() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(new File("person")));

            Student student = new Student();
            student.setId(18);
            student.setName("aaa");
            student.setAa(1);

            outputStream.writeObject(student);

            System.out.println("serialize success...");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student deSerializeStudent() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(new File("person")));

            Student student = (Student) objectInputStream.readObject();

            return student;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
