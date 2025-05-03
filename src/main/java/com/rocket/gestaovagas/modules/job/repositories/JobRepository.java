package com.rocket.gestaovagas.modules.job.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocket.gestaovagas.modules.job.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
