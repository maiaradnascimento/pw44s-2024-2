package br.edu.utfpr.pb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {

    private Long id;

    @NotNull(message = "A data do pedido não pode ser nula.")
    private LocalDateTime data;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    private Long usuarioId;

    private List<PedidoItemDTO> itens;
}
