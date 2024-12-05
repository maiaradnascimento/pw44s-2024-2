package br.edu.utfpr.pb.controller;

import br.edu.utfpr.pb.model.Produto;
import br.edu.utfpr.pb.service.ProdutoService;
import br.edu.utfpr.pb.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createProduto(@RequestBody Produto produto) {
        produtoService.save(produto);
        return ResponseEntity.ok(new GenericResponse("Produto saved!"));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Produto>> getProdutosByNome(@RequestParam String nome) {
        return ResponseEntity.ok(produtoService.findByNomeContaining(nome));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Produto>> getProdutosByCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findByCategoriaId(id));
    }
}
