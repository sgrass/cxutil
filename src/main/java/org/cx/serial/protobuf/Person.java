package org.cx.serial.protobuf;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

/**
 * @author grass
 * @date 2017/10/29
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -3820231825416706579L;

    @Protobuf(fieldType = FieldType.STRING)
    private String name;

    @Protobuf(fieldType = FieldType.INT32)
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
