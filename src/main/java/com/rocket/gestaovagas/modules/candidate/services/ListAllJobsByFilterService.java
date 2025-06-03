package com.rocket.gestaovagas.modules.candidate.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocket.gestaovagas.modules.job.JobEntity;
import com.rocket.gestaovagas.modules.job.repositories.JobRepository;

@Service
public class ListAllJobsByFilterService {

    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
