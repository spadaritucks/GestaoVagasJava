package com.rocket.gestaovagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank()
    @Pattern(regexp = "^(?!\\s*$).+", message= "O campo [username] não deve conter espaço")
    private String username;
    private String name;
    @Email(message = "O campo (email) deve conter um e-mail válido")
    private String email;
    @Length(min = 10, max = 100, message="A senha deve conter entre 10 a 100 caracteres")
    private String password;
    private String description;
    private String curriculm;


}
