package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author by HZL
 * @date 2019/12/19 15:13
 * @description
 */

@Data
public class User implements Serializable {
    private static final long serialVersionUID=1L;
    String uid;
    String username;
    String password;

    public User(){
        super();
    }

    public User(String uid,String username,String password){
        super();
        this.uid=uid;
        this.username=username;
        this.password=password;
    }
}
