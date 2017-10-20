package org.cx.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsTpoicReceiver {

    public static void main(String[] args) {
        ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://192.168.254.130:61616");

        Connection conn = null;

        try {
            conn = connFactory.createConnection();
            conn.setClientID("first-topic1");
            conn.start();

            Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);

            Topic topic = session.createTopic("first-topic1");

            MessageConsumer consumer = session.createDurableSubscriber(topic, "first-topic1");

            TextMessage txtMsg = (TextMessage) consumer.receive();
            System.out.println(txtMsg.getText());

            session.commit();
            session.close();

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
