package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPSRepository extends PagingAndSortingRepository<User,String>{

}
