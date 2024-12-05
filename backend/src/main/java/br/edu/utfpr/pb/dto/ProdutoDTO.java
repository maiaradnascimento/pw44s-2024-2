package br.edu.utfpr.pb.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;

    @NotNull(message = "O nome do produto não pode ser nulo.")
    @Size(min = 2, max = 100, message = "O nome do produto deve ter entre 2 e 100 caracteres.")
    private String nome;

    private String descricao;

    @NotNull(message = "O preço do produto não pode ser nulo.")
    private Double preco;

    @NotNull(message = "A categoria do produto não pode ser nula.")
    private Long categoriaId;
}
