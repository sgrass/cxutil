package org.cx.serial.protobuf;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import java.io.IOException;

/**
 * @author grass
 * @date 2017/10/29
 */
public class ProtoBufTest {

    public static void main(String[] args) throws IOException {
        executeWithProtoBuf();
    }

    /**
     * 百度提供的protobuf操作工具包
     * @throws IOException
     */
    private static void executeWithProtoBuf() throws IOException {
        Person person=new Person();
        person.setName("hello");
        person.setAge(18);

        Codec<Person> personCodec = ProtobufProxy.create(Person.class, false);


        byte[] bytes = personCodec.encode(person);

        Person p = personCodec.decode(bytes);
        System.out.println(p);
    }
}
