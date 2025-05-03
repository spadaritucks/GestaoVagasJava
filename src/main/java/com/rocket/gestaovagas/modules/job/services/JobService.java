package com.rocket.gestaovagas.modules.job.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.gestaovagas.modules.job.JobEntity;
import com.rocket.gestaovagas.modules.job.repositories.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){
       return this.jobRepository.save(jobEntity);
    }
}
