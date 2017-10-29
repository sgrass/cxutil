package org.cx.serial.simple;

import java.io.*;

/**
 * @author grass
 * @date 2017/10/29
 */
public class SerializeDemo {
    public static void main(String[] args) {

        serializePerson();

        Person.height = 5;

        Person p = deSerializePerson();
        System.out.println(p.height); //序列化并不保存静态变量的状态,
        System.out.println(p);  //transient 序列化 忽略的字段
    }

    private static Person deSerializePerson() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(new File("person")));

            Person person = (Person) objectInputStream.readObject();

            objectInputStream.close();
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void serializePerson() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(new File("person")));

            Person person = new Person();
            person.setName("aaa");
            person.setAge(18);

            outputStream.writeObject(person);

            System.out.println("serialize success...");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
