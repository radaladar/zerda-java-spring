package com.greenfox.exams.spring.domain;/// Created by BB on 2017-01-11.

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Integer>{
    List<Project> findAll();
}
