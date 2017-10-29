package org.cx.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author grass
 * @date 2017/10/28
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("sam", "valueabc");
        hashMap.put("sam", "valueabc2");
        System.out.println(hashMap.get("sam"));
        /*
        按位运算符 异或 两个位运算不一致为16 -1 = 15  一致为0
        jdk 里面规定数组的长度是 2 N -1
        2 3 =8 -1 = 7
        .misc.Hashing.stringHash32((String) k);来获取索引值
        0000 1111  >>> 3 = ？  0000 000 1
        00001  位移算法 都是降低我们冲突
        em.out.println(Integer.toBinaryString(15));
        System.out.println("1<<6  的值是"+(1<<6));
        二进制转十进制    1<<6 = 64  64-1 = 63 : 111111
        System.out.println(Integer.parseInt("111101",2));
        System.out.println("3<<1  的值是"+(3<<1*2));
        */
    }
}
