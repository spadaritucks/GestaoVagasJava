package com.rocket.gestaovagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rocket.gestaovagas.exceptions.UserFoundException;
import com.rocket.gestaovagas.modules.company.CompanyEntity;
import com.rocket.gestaovagas.modules.company.repositories.CompanyRepository;

@Service
public class CompanyServices {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(user -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);
       

        return this.companyRepository.save(companyEntity);
    }
}
