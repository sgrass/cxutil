package org.cx.queue.block;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author grass
 * @date 2018/9/1
 */
public class PrintProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<>();

    private final RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                Request request = blockingQueue.take();
                System.out.println("print request:" + request);
                nextProcessor.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        blockingQueue.add(request);
    }


}
