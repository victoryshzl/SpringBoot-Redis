package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String>{

}
