package br.edu.utfpr.pb.repository;

import br.edu.utfpr.pb.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // select * from tb_categoria where nome LIKE %:nome%
    List<Categoria> findByNomeContaining(String nome);
}
