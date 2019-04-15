package com.qf;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Mainn {
    public static void main(String[] args) {
        //连接redis
      //  Jedis jedis = new Jedis("47.112.109.89",6379);
        Jedis jedis = getJedis();
        jedis.auth("root");
        //操作redis
        jedis.set("name", "w11");
        jedis.set("age", "798");

        //关闭连接
        jedis.close();
    System.out.println("操作完成");
    }
    public static Jedis getJedis(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(5);
        config.setMaxIdle(10);
        config.setMaxTotal(100);
        JedisPool pool = new JedisPool(config,"47.112.109.89",6379,60000,"root");
        return pool.getResource();
    }
}
