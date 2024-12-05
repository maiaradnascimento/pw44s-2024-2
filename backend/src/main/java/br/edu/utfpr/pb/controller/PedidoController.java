package br.edu.utfpr.pb.controller;

import br.edu.utfpr.pb.model.Pedido;
import br.edu.utfpr.pb.service.PedidoService;
import br.edu.utfpr.pb.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createPedido(@RequestBody Pedido pedido) {
        pedidoService.save(pedido);
        return ResponseEntity.ok(new GenericResponse("Pedido saved!"));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Pedido>> getPedidosByUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findByUsuarioId(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pedido>> getPedidosByDataBetween(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        return ResponseEntity.ok(pedidoService.findByDataBetween(startDate, endDate));
    }
}
