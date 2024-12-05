package br.edu.utfpr.pb.controller;

import br.edu.utfpr.pb.model.Endereco;
import br.edu.utfpr.pb.service.EnderecoService;
import br.edu.utfpr.pb.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createEndereco(@RequestBody Endereco endereco) {
        enderecoService.save(endereco);
        return ResponseEntity.ok(new GenericResponse("Endereco saved!"));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Endereco>> getEnderecosByUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findByUsuarioId(id));
    }
}
