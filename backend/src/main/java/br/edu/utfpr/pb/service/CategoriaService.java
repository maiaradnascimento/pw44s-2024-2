package br.edu.utfpr.pb.service;

import br.edu.utfpr.pb.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> findByNomeContaining(String nome);
    List<Categoria> findAll();
    Categoria save(Categoria categoria);
}
