package br.edu.utfpr.pb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_item_pedido")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoId id = new ItemPedidoId();

    @ManyToOne
    @MapsId("pedidoId")
    private Pedido pedido;

    @ManyToOne
    @MapsId("produtoId")
    private Produto produto;

    private Integer quantidade;

    //adicionar preço do item no carrinho para não afetar o preço atualizado no estoque
}
