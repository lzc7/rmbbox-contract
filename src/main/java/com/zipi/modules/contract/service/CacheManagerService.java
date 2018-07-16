package com.zipi.modules.contract.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Slf4j
@Service
public class CacheManagerService  {
    /**
     * 获取一个jedis 客户端
     *
     * @return
     */
    @Autowired
    protected JedisPool jedisPool;

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key, String value, int liveTime) {
        this.set(key, value);
        Jedis jedis = null;
        try {
            jedis= jedisPool.getResource();
            jedis.expire(key, liveTime);
        }catch (Exception e){
            log.error("", e);
            if(jedis!=null){
                jedisPool.returnBrokenResource(jedis);
                jedis = null;
            }
        }finally {
            if(jedis != null ) {
                jedisPool.returnResource(jedis);
            }
        }
    }

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis= jedisPool.getResource();
            jedis.set(key, value);
        }catch (Exception e){
            log.error("", e);
            if(jedis!=null){
                jedisPool.returnBrokenResource(jedis);
                jedis = null;
            }
        }finally {
            if(jedis != null ) {
                jedisPool.returnResource(jedis);
            }
        }
    }



    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;
        String  a = "";
        try {
            jedis= jedisPool.getResource();
            a = jedis.get(key);
        }catch (Exception e){
            log.error("", e);
            if(jedis!=null){
                jedisPool.returnBrokenResource(jedis);
                jedis = null;
            }
        }finally {
            if(jedis != null ) {
                jedisPool.returnResource(jedis);
            }
        }
        return a;
    }

}
