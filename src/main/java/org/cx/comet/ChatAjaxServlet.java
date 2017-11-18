package org.cx.comet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * @author grass
 * @date 2017/11/18
 */
@WebServlet
public class ChatAjaxServlet extends HttpServlet {
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String message = req.getParameter("message");
        String content = String.format("User [%s] : %s", userName, message);

        ServletContext servletContext = req.getServletContext();

        BlockingQueue<String> messages = (BlockingQueue<String>) servletContext.getAttribute("messages");

        messages.offer(content);
    }
}
