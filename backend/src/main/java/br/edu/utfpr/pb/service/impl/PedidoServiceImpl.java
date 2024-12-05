package br.edu.utfpr.pb.service.impl;

import br.edu.utfpr.pb.model.Pedido;
import br.edu.utfpr.pb.repository.PedidoRepository;
import br.edu.utfpr.pb.service.PedidoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> findByUsuarioId(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Pedido> findByDataBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return pedidoRepository.findByDataBetween(startDate, endDate);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
