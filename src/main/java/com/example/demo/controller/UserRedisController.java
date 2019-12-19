package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.dao.UserRedisDao;
import com.example.demo.service.UserRedisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author by HZL
 * @date 2019/12/19 15:46
 * @description
 */

@Controller
public class UserRedisController {
    @Resource
    private UserRedisDao userRedisDao;
    @Resource
    private UserRedisService userRedisService;

    //////Redis
    @RequestMapping(value="/getStringByRedis")
    public String getStringByRedis(Model model) {
        userRedisDao.stringRedisTemplate();
        String s=userRedisService.getStrByRedis();
        model.addAttribute("redis", s);
        return "redis";
    }

    @RequestMapping(value="/insertUserByRedis")
    public String insertUserByRedis(String uid,String username,String password) {
        User user=new User(uid,username,password);
        userRedisService.insertUserByRedis(user);
        return "insert";
    }

    @RequestMapping(value="/findUserByRedis")
    public String selectUserByRedis(String uid,HttpSession session ) {
        User user=userRedisService.findUserByRedis(uid);
        session.setAttribute("user", user);
        return "s";
    }

}
