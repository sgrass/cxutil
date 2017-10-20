package org.cx.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsSender {

    public static void transSession(ConnectionFactory connectFactory) {
        Connection conn = null;
        try {
          conn = connectFactory.createConnection();
          //session生产和消费消息的单线程上下文 
          Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
          conn.start();

          // 创建队列（如果队列已经存在则不会创建， first-queue是队列名称）
          // destination表示目的地
          Destination dest = session.createQueue("first-queue");

          // 创建消息发送者
          MessageProducer produce = session.createProducer(dest);

          TextMessage txtMsg = session.createTextMessage("hello ");
          txtMsg.setStringProperty("name", "sean");
          produce.send(txtMsg);

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
    
    
    public static void noTransSession(ConnectionFactory connectFactory) {
        Connection conn = null;
        try {
          conn = connectFactory.createConnection();
          
          Session session = conn.createSession(false, Session.CLIENT_ACKNOWLEDGE);
          conn.start();

          // 创建队列（如果队列已经存在则不会创建， first-queue是队列名称）
          // destination表示目的地
          Destination dest = session.createQueue("first-queue");

          // 创建消息发送者
          MessageProducer produce = session.createProducer(dest);

          for (int i = 0; i < 10; i++) {
              TextMessage txtMsg = session.createTextMessage("hello " + i);
              txtMsg.setStringProperty("name", "sean");
              produce.send(txtMsg);
          }

//          session.commit();
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
        ConnectionFactory connectFactory = new ActiveMQConnectionFactory("tcp://192.168.254.130:61616");
        noTransSession(connectFactory);
    }

}