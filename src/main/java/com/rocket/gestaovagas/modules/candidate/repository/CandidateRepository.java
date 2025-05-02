package com.rocket.gestaovagas.modules.candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rocket.gestaovagas.modules.candidate.CandidateEntity;


public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
}
