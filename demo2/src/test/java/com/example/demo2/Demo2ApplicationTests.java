package com.example.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

    @Test
    public void contextLoads() {
            // 创建并填充节点信息(我是分支)
            Set<HostAndPort> nodes = new HashSet<>();
            nodes.add(new HostAndPort("192.168.1.100", 7000));
            nodes.add(new HostAndPort("192.168.1.100", 7001));
            nodes.add(new HostAndPort("192.168.1.100", 7002));
            nodes.add(new HostAndPort("192.168.1.100", 7003));
            nodes.add(new HostAndPort("192.168.1.100", 7004));
            nodes.add(new HostAndPort("192.168.1.100", 7005));

            // 创建JedisCluster对象
            JedisCluster jedisCluster = new JedisCluster(nodes);

            // 使用jedisCluster操作redis
            String key = "jedisCluster";
            String setResult = jedisCluster.set(key, "hello redis!");
            System.out.println(setResult);

            String getResult = jedisCluster.get(key);
            System.out.println(getResult);

            // 关闭jedisCluster（程序执行完后才能关闭，内部封装了连接池）
            jedisCluster.close();



    }

}
