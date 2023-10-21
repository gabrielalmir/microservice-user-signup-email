package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(
    @NotBlank(message = "Nome de usuário não deve ser vazio")
    String name,
    @NotBlank(message = "E-mail não deve ser vazio")
    @Email(message = "E-mail deve ser válido")
    String email
) {}
