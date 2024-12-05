package br.edu.utfpr.pb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemDTO {

    private Long id;

    @NotNull(message = "O ID do produto não pode ser nulo.")
    private Long produtoId;

    @NotNull(message = "A quantidade não pode ser nula.")
    private Integer quantidade;

    @NotNull(message = "O preço do item não pode ser nulo.")
    private Double preco;
}

