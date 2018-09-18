package org.cx.lock;

import org.apache.catalina.Cluster;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class RedisLock {

  private final static Logger log = LoggerFactory.getLogger(RedisLock.class);

  private final static String SCRIPT_LUA_LOCK = "if redis.call('set',KEYS[1],ARGV[1],'PX',ARGV[2],'NX') then return 1 else return 0 end";

  private final static String SCRIPT_LUA_UN_LOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

  /**
   * 默认超时时间 5秒
   */
  private final static long LOCK_TIME_DEFAULT = 5 * 1000;

  private final static String KEY_PREFIX = "lock:";

  private Jedis jedis;

  private String lockKey;

  private String reqId;

  private RedisLock() {}

  public RedisLock(Jedis jedis, String lockKey) {
    this.jedis = jedis;
    this.lockKey = KEY_PREFIX.concat(lockKey);
    this.reqId = UUID.randomUUID().toString();
  }

  private String getScriptLuaLock() {
    return jedis.scriptLoad(SCRIPT_LUA_LOCK);
  }

  private String getScriptLuaUnLock() {
    return jedis.scriptLoad(SCRIPT_LUA_UN_LOCK);
  }

  public boolean tryLock() {
    return tryLock(LOCK_TIME_DEFAULT);
  }

  public void lock() {
    lock(LOCK_TIME_DEFAULT);
  }

  public boolean tryLock(long lockTimeMS) {
    List<String> keys = Arrays.asList(lockKey);
    List<String> args = Arrays.asList(reqId, String.valueOf(lockTimeMS));
    Object obj =  jedis.evalsha(getScriptLuaLock(), keys, args);
    log.info(format("DistributedLock#tryLock() --> lockKey:%s, reqId:%s, result:%s", lockKey, reqId, obj));
    if (StringUtils.equals("1", obj.toString())) {
      return true;
    }
    return false;
  }

  public void lock(long lockTimeMS) {
    if (!tryLock(lockTimeMS)) {
      while (!Thread.currentThread().isInterrupted()) {
        if (tryLock(lockTimeMS)) {
          break;
        }

        try {
          TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
          log.error("DistributedLock#lock() --> thread sleep InterruptedException...");
        }
      }
    }
  }

  public void unLock() {
    List<String> keys = Arrays.asList(lockKey);
    List<String> args = Arrays.asList(reqId);
    Object obj =  jedis.evalsha(getScriptLuaUnLock(), keys, args);
    if (!StringUtils.equals("1", obj.toString())) {
      log.error(format("DistributedLock#unLock() --> unlock error lockKey:%s, reqId:%s", lockKey, reqId));
      log.error(format("ttl:%s", jedis.ttl(lockKey)));
    }
  }
}
