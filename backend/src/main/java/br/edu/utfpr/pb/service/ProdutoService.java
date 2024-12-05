package br.edu.utfpr.pb.service;

import br.edu.utfpr.pb.model.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> findByNomeContaining(String nome);
    List<Produto> findByCategoriaId(Long categoriaId);
    Produto save(Produto produto);
    List<Produto> findAll();
}

