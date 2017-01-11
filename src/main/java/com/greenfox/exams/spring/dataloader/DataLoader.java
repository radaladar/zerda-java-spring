/// Created by BB on 2017-01-11.
package com.greenfox.exams.spring.dataloader;

import com.greenfox.exams.spring.domain.Project;
import com.greenfox.exams.spring.domain.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void run(String... strings) throws Exception {
        projectRepository.deleteAll();
        projectRepository.save(new Project("Clash of Zerda", "android"));
        projectRepository.save(new Project("Clash of Zerda", "spring"));
        projectRepository.save(new Project("Zerda Reader", "android"));
        projectRepository.save(new Project("Zerda Reader", "spring"));
        projectRepository.save(new Project("Konnekt Contact Manager", "spring"));
    }
}