package org.cx.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQXAConnectionFactory;

public class JmsToipcSender {

    public static void main(String[] args) {
        ConnectionFactory connFactory = new ActiveMQXAConnectionFactory("tcp://192.168.254.130:61616");
        Connection conn = null;
        try {
            conn = connFactory.createConnection();
            conn.start();

            Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("first-topic1");

            MessageProducer producer = session.createProducer(destination);

            TextMessage txtMsg = session.createTextMessage("广播一下..");
            producer.send(txtMsg);
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

}
