package com.ms.user.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDto {
    @NotBlank(message="Usuário não pode ser vazio")
    private UUID userId;

    @NotBlank(message = "E-mail não deve ser vazio")
    @Email(message = "Deve conter um e-mail válido")
    private String emailTo;

    @NotBlank(message = "Assunto não pode ser vazio")
    private String subject;

    @NotBlank(message = "Mensagem não pode ser vazia")
    private String text;
}
