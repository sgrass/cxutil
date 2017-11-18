package org.cx.comet;

import org.apache.bcel.verifier.structurals.ControlFlowGraph;
import org.apache.catalina.comet.CometEvent;
import org.apache.catalina.comet.CometProcessor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * servlet3.0之前的comet方式，仅用于理解，bug不少
 * 类似servlet3.0之后异步方式
 * @see javax.servlet.AsyncListener
 *
 * @author grass
 * @date 2017/11/18
 */
@WebServlet("/chat/comet")
public class ChatCometServlet extends HttpServlet implements CometProcessor {

    //所有的用户连接
    private List<Writer> streams;

    private BlockingQueue<String> messages;

    @Override
    public void init(ServletConfig config) throws ServletException {
        streams = new CopyOnWriteArrayList<>();
        messages = new LinkedBlockingQueue<>();

        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("messages", messages);

        Thread thread = new Thread(()->{
            try {
                //获取最新消息
                final String message = messages.take();

                //广播所有的客户端
                streams.forEach((stream)->{
                    try {
                        stream.write(message);
                        stream.flush();
                    } catch (Exception e) {
                    }

                });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }, "聊天广播线程");
        thread.start();
    }

    @Override
    public void event(CometEvent cometEvent) throws IOException, ServletException {
        CometEvent.EventType eventType = cometEvent.getEventType();

        switch (eventType) {
            case BEGIN:
                onstart(cometEvent);
                break;
            case END:
                onComplete(cometEvent);
                break;
            case ERROR:
                onError(cometEvent);
                break;
        }
    }


    private void onstart(CometEvent event) throws IOException {
        HttpServletResponse resp = event.getHttpServletResponse();

        PrintWriter stream = resp.getWriter();

        streams.add(stream);

        System.out.printf("当前在线的用户数量：%s", streams.size());


    }

    private void onComplete(CometEvent event) throws IOException {
        HttpServletResponse resp = event.getHttpServletResponse();

        PrintWriter stream = resp.getWriter();

        //移除
        streams.remove(stream);

        System.out.printf("当前在线的用户数量：%s", streams.size());

        event.close();
    }

    private void onError(CometEvent event) throws IOException {
        onComplete(event);
    }
}
