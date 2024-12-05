package br.edu.utfpr.pb.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    private Long id;

    @NotNull(message = "O nome da categoria não pode ser nulo.")
    @Size(min = 2, max = 50, message = "O nome da categoria deve ter entre 2 e 50 caracteres.")
    private String nome;
}
