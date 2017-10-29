package org.cx.serial.simple;

import java.io.*;

/**
 * @author grass
 * @date 2017/10/29
 */
public class SerialSaveDemo {

    public static void main(String[] args) {
        serializePerson();

//        deSerializePerson();
    }

    private static void serializePerson() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(new File("person")));

            Person person = new Person();
            person.setName("aaa");
            person.setAge(18);

            /**
             * 同一对象多次写入，第二次仅多出几个字节的引用关系，并不会导致叠加翻倍
             */
            outputStream.writeObject(person);
            outputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person1 = (Person) objectInputStream.readObject();

            person.setAge(19);
            outputStream.writeObject(person);
            outputStream.flush();

            Person person2 = (Person) objectInputStream.readObject();

            //读出多次写入的对象，地址是相等的
            boolean flag = person1 == person2;
            System.out.printf("flag--->%s \n",flag);
            System.out.printf("person1-->%s\n",person1);
            System.out.printf("person2-->%s\n",person2);
            System.out.printf("长度是-->%s \n", new File("person").length());

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void deSerializePerson() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(new File("person")));

            Person person = (Person) objectInputStream.readObject();
            Person person2 = (Person) objectInputStream.readObject();

            //读出多次写入的对象，地址是相等的
            boolean flag = person == person2;

            System.out.printf("flag--->%s",flag);

            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
