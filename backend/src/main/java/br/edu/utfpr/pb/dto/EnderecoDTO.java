package br.edu.utfpr.pb.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private Long id;

    @NotNull(message = "O endereço não pode ser nulo.")
    @Size(min = 5, max = 100, message = "O endereço deve ter entre 5 e 100 caracteres.")
    private String rua;

    @NotNull(message = "O número não pode ser nulo.")
    private Integer numero;

    private String complemento;

    @NotNull(message = "O bairro não pode ser nulo.")
    @Size(min = 2, max = 50, message = "O bairro deve ter entre 2 e 50 caracteres.")
    private String bairro;

    @NotNull(message = "A cidade não pode ser nula.")
    @Size(min = 2, max = 50, message = "A cidade deve ter entre 2 e 50 caracteres.")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo.")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres.")
    private String estado;

    @NotNull(message = "O CEP não pode ser nulo.")
    @Size(min = 8, max = 8, message = "O CEP deve ter 8 caracteres.")
    private String cep;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    private Long usuarioId;
}

