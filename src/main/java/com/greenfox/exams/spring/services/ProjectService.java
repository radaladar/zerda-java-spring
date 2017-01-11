/// Created by BB on 2017-01-11.
package com.greenfox.exams.spring.services;

import com.greenfox.exams.spring.domain.Project;
import com.greenfox.exams.spring.domain.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findall() {
        return projectRepository.findAll();
    }
}
