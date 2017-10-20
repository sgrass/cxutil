package org.cx.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JsmReceive {

    public static void transSession(ConnectionFactory connFactory) {
        Connection conn = null;
        try {
            conn = connFactory.createConnection();
            conn.start();
            Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);

            // 创建队列（如果队列已经存在则不会创建， first-queue是队列名称）
            // destination表示目的地
            Destination dest = session.createQueue("first-queue");
            MessageConsumer consumer = session.createConsumer(dest);

            // receive阻塞的
            TextMessage txtMsg = (TextMessage) consumer.receive();

            // 获取消息属性
            System.out.println(txtMsg.getText() + "-->" + txtMsg.getStringProperty("name"));

            session.commit();
            session.close();

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void noTransSession(ConnectionFactory connFactory) {
        Connection conn = null;
        try {
            conn = connFactory.createConnection();
            conn.start();

            /**
             * false时，第二个参数才生效 
             * AUTO_ACKNOWLEDGE 自动签收，不需要commit 
             * CLIENT_ACKNOWLEDGE 需要手动签收 txtMsg.acknowledge(),第n个签收后，之前的消息也都会被确认 
             * DUPS_OK_ACKNOWLEDGE 延迟确认
             */
            Session session = conn.createSession(false, Session.CLIENT_ACKNOWLEDGE);

            // 创建队列（如果队列已经存在则不会创建， first-queue是队列名称）
            Destination dest = session.createQueue("first-queue");
            MessageConsumer consumer = session.createConsumer(dest);

            for (int i = 0; i < 10; i++) {
                if (i < 5) {
                    // receive阻塞的
                    TextMessage txtMsg = (TextMessage) consumer.receive();

                    // 获取消息属性
                    System.out.println(txtMsg.getText() + "-->" + txtMsg.getStringProperty("name"));
                    // session.commit();
                    
                    txtMsg.acknowledge();
                }
            }

            session.close();

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://192.168.254.130:61616");
        // transSession(connFactory);
        noTransSession(connFactory);
    }

}
