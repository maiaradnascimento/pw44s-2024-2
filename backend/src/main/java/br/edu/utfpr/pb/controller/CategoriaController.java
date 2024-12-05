package br.edu.utfpr.pb.controller;

import br.edu.utfpr.pb.model.Categoria;
import br.edu.utfpr.pb.service.CategoriaService;
import br.edu.utfpr.pb.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createCategoria(@RequestBody Categoria categoria) {
        categoriaService.save(categoria);
        return ResponseEntity.ok(new GenericResponse("Categoria saved!"));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Categoria>> getCategoriasByNome(@RequestParam String nome) {
        return ResponseEntity.ok(categoriaService.findByNomeContaining(nome));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.findAll());
    }
}
