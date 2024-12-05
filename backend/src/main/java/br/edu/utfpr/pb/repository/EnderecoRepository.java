package br.edu.utfpr.pb.repository;

import br.edu.utfpr.pb.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    // select * from tb_endereco where usuario_id = :usuarioId
    List<Endereco> findByUsuarioId(Long usuarioId);
}
