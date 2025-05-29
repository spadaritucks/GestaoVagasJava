package com.rocket.gestaovagas.modules.candidate.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rocket.gestaovagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import com.rocket.gestaovagas.modules.candidate.repositories.CandidateRepository;

@Service
public class ProfileCandidadeService {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute( UUID id) {

        var candidate = this.candidateRepository.findById(id)
        .orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
        .description(candidate.getDescription())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .id(candidate.getId())
        .build();


    return candidateDTO;



    }
}
