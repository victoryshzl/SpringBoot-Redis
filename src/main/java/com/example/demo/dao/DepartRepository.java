package com.example.demo.dao;

import com.example.demo.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepository extends JpaRepository<Depart, Integer> {

}
