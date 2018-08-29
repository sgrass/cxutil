package org.cx.lambda;

import java.util.Random;
import java.util.function.Supplier;

public class MobileSupplier implements Supplier<Mobile> {
    private int index = 0;

    private Random random = new Random();

    @Override
    public Mobile get() {
        index++;
        return new Mobile("aa"+index, random.nextInt(1000));
    }
}
