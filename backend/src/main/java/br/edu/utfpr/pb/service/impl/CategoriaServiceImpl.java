package br.edu.utfpr.pb.service.impl;

import br.edu.utfpr.pb.model.Categoria;
import br.edu.utfpr.pb.repository.CategoriaRepository;
import br.edu.utfpr.pb.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findByNomeContaining(String nome) {
        return categoriaRepository.findByNomeContaining(nome);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
