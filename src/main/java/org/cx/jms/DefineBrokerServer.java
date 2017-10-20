package org.cx.jms;

import org.apache.activemq.broker.BrokerService;

public class DefineBrokerServer {

  public static void main(String[] args) throws Exception {
    BrokerService brokerService = new BrokerService();
    brokerService.setUseJmx(true);
    brokerService.addConnector("tcp://192.168.254.130:61616");
    brokerService.start();
  }

}
