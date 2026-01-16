package com.Project.Disney.web.dto;

import com.Project.Disney.entity.more.Active;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PeopleRequestDto(

        @NotBlank
        String name,
        @NotBlank
        @Column(unique = true)
        @Size(min = 11, max = 11, message = "Informe um valor de CPF válido!")
        String cpf,
        @NotBlank
        @Column(unique = true)
        @Email
        String email,
        @NotNull
        @Enumerated(EnumType.STRING)
        Active active,
        @NotNull
        Long plan
) {
}
