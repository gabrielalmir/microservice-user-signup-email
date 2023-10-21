package com.ms.email.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRecordDto(
    @NotBlank(message="Usuário não pode ser vazio")
    UUID userId,
    @NotBlank(message = "E-mail não deve ser vazio")
    @Email(message = "Deve conter um e-mail válido")
    String emailTo,
    @NotBlank(message = "Assunto não pode ser vazio")
    String subject,
    @NotBlank(message = "Mensagem não pode ser vazia")
    String text
) {}
