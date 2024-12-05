package br.edu.utfpr.pb.repository;

import br.edu.utfpr.pb.model.ItemPedido;
import br.edu.utfpr.pb.model.ItemPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoId> {

    // select * from tb_item_pedido where pedido_id = :pedidoId
    List<ItemPedido> findByPedidoId(Long pedidoId);

    // select * from tb_item_pedido where produto_id = :produtoId
    List<ItemPedido> findByProdutoId(Long produtoId);
}
