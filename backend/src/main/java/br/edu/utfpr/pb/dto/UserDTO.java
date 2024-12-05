package br.edu.utfpr.pb.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotNull(message = "O atributo usuário não pode ser nulo.")
    @Size(min = 4, max = 50, message = "O nome de usuário deve ter entre 4 e 50 caracteres.")
    private String username;

    @NotNull(message = "O nome de exibição não pode ser nulo.")
    @Size(min = 4, max = 50, message = "O nome de exibição deve ter entre 4 e 50 caracteres.")
    private String displayName;

    @NotNull(message = "A senha não pode ser nula.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "A senha deve conter letras maiúsculas, minúsculas e números.")
    private String password;
}

