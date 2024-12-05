package br.edu.utfpr.pb.service.impl;

import br.edu.utfpr.pb.model.Produto;
import br.edu.utfpr.pb.repository.ProdutoRepository;
import br.edu.utfpr.pb.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> findByNomeContaining(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    @Override
    public List<Produto> findByCategoriaId(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
