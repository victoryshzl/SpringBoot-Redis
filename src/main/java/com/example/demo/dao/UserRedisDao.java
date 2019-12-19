package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author by HZL
 * @date 2019/12/19 15:19
 * @description
 */

@SuppressWarnings("ALL")
@Repository
public class UserRedisDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Autowired
    RedisTemplate redisTemplate;
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void stringRedisTemplate(){
        valOpsStr.set("Hi","SpringBoot-Redis");
    }
    public String getStringByRedis(){
        return valOpsStr.get("Hi");
    }

    public void insertUserByRedis(User user){
        valOps.set(user.getUid(),user);
    }
    public User findUserByRedis(String uid){
        return (User) valOps.get(uid);
    }
}
