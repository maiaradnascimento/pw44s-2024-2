package br.edu.utfpr.pb.service;

import br.edu.utfpr.pb.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoService {
    List<Pedido> findByUsuarioId(Long usuarioId);
    List<Pedido> findByDataBetween(LocalDateTime startDate, LocalDateTime endDate);
    Pedido save(Pedido pedido);
}
