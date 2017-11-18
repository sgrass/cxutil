package org.cx.designpattern.observer;

import java.util.Observable;

/**
 * @author grass
 * @date 2017/11/18
 */
public class Antique extends Observable {

    private int price;

    public Antique(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        super.setChanged();
        super.notifyObservers(price);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Antique{" +
                "price=" + price +
                '}';
    }
}
