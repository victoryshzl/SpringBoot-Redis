package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserRedisDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author by HZL
 * @date 2019/12/19 15:48
 * @description
 */

@Service
public class UserRedisService {
    @Resource
    private UserRedisDao userRedisDao;

    public String getStrByRedis() {
        return userRedisDao.getStringByRedis();
    }
    public void insertUserByRedis(User user) {
        userRedisDao.insertUserByRedis(user);

    }
    public User findUserByRedis(String uid) {
        return userRedisDao.findUserByRedis(uid);
    }
}
