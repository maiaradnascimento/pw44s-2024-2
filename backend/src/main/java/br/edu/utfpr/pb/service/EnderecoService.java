package br.edu.utfpr.pb.service;

import br.edu.utfpr.pb.model.Endereco;

import java.util.List;

public interface EnderecoService {
    List<Endereco> findByUsuarioId(Long usuarioId);
    Endereco save(Endereco endereco);
}
