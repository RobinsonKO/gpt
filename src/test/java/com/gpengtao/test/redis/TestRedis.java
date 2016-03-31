package com.gpengtao.test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by gpengtao on 15/7/22.
 */
public class TestRedis {

    @Test
    public void test() {
        Jedis jedis = new Jedis("10.86.36.12");
        String authRet = jedis.auth("geng1234.");
        System.out.println("auth : " + authRet);
        String name = jedis.get("name");
        System.out.println(name);

    }

    @Test
    public void test_(){
//        List<String> identityList = Splitter.on('/').trimResults().omitEmptyStrings().splitToList("VCDXYR");

    }
}
