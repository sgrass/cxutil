package org.cx.queue.block;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author grass
 * @date 2018/9/1
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> blockingQueue = new LinkedBlockingQueue();

    @Override
    public void processorRequest(Request request) {
        blockingQueue.add(request);
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                Request request = blockingQueue.take();
                System.out.println("save request:" + request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
