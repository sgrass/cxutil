package org.cx.queue.block;


/**
 * @author grass
 * @date 2018/9/1
 */
public class Demo {

    PrintProcessor printProcessor;

    public Demo() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {
        new Demo().doTest(new Request("aa"));

    }


    public void doTest(Request request) {
        printProcessor.processorRequest(request);
    }
}
