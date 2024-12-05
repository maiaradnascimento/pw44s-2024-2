package br.edu.utfpr.pb.service.impl;

import br.edu.utfpr.pb.model.Endereco;
import br.edu.utfpr.pb.repository.EnderecoRepository;
import br.edu.utfpr.pb.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> findByUsuarioId(Long usuarioId) {
        return enderecoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
