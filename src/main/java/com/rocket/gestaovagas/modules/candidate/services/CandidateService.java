package com.rocket.gestaovagas.modules.candidate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rocket.gestaovagas.exceptions.UserFoundException;
import com.rocket.gestaovagas.modules.candidate.CandidateEntity;
import com.rocket.gestaovagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {

        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

                var password = passwordEncoder.encode(candidateEntity.getPassword());
                candidateEntity.setPassword(password);

        return this.candidateRepository.save(candidateEntity);
    }
}
