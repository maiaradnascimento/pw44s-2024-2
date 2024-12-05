package br.edu.utfpr.pb.repository;

import br.edu.utfpr.pb.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // select * from tb_pedido where usuario_id = :usuarioId
    List<Pedido> findByUsuarioId(Long usuarioId);

    // select * from tb_pedido where data between :startDate and :endDate
    List<Pedido> findByDataBetween(LocalDateTime startDate, LocalDateTime endDate);
}
