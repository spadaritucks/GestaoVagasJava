package com.rocket.gestaovagas.modules.job.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocket.gestaovagas.modules.job.JobEntity;
import com.rocket.gestaovagas.modules.job.dto.CreateJobDTO;
import com.rocket.gestaovagas.modules.job.services.JobService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create( @Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request){
        var companyId = request.getAttribute("company_id");

            var jobEntity = JobEntity.builder()
            .benefits(createJobDTO.getBenefits())
            .companyId(UUID.fromString(companyId.toString()))
            .description(createJobDTO.getDescription())
            .level(createJobDTO.getLevel())
            .build();
        return jobService.execute(jobEntity);
    }
}
