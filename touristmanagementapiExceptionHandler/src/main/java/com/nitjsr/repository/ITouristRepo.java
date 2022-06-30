package com.nitjsr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitjsr.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer>{

}
