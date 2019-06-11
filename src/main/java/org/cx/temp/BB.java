package org.cx.temp;

/**
 * @author grass
 * @date 2019/2/24
 */
public class BB {
    public static void main(String[] args) {
        System.out.println(new BB().getClass().getClassLoader());
        System.out.println(new Object().getClass().getClassLoader());
    }
}
