package com.greenfox.exams.spring.domain;/// Created by BB on 2017-01-11.

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository <Review, Integer> {
}
