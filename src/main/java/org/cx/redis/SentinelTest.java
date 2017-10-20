package org.cx.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class SentinelTest {

    public static void main(String[] args) {
        Set<String> sentinels = new HashSet<String>();
        sentinels.add(new HostAndPort("192.168.254.130", 26379).toString());
        sentinels.add(new HostAndPort("192.168.254.131", 26379).toString());
        sentinels.add(new HostAndPort("192.168.254.132", 26379).toString());
        JedisSentinelPool sentinelPool = new JedisSentinelPool("redis-master", sentinels);
        
        System.out.println("Current master: " + sentinelPool.getCurrentHostMaster().toString());
        
        Jedis master = sentinelPool.getResource();
        master.set("username","abcd");
        Jedis master2 = sentinelPool.getResource();
        String value = master2.get("username");
        System.out.println("username: " + value);
        master2.close();
        sentinelPool.close();
        sentinelPool.destroy();
    }

}
