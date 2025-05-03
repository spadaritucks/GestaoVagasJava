package com.rocket.gestaovagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocket.gestaovagas.modules.company.CompanyEntity;
import com.rocket.gestaovagas.modules.company.services.CompanyServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServices companyServices;

    @PostMapping
    public ResponseEntity<Object> insert(@Valid @RequestBody CompanyEntity companyEntity){
        try{
            var result = this.companyServices.execute(companyEntity);

            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
