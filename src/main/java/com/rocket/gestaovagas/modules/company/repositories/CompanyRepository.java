package com.rocket.gestaovagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocket.gestaovagas.modules.company.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity>findByUsernameOrEmail(String username, String email);

    Optional<CompanyEntity>findByUsername(String username);
}
