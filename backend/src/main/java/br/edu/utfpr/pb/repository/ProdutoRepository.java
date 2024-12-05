package br.edu.utfpr.pb.repository;

import br.edu.utfpr.pb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // select * from tb_produto where nome LIKE %:nome%
    List<Produto> findByNomeContaining(String nome);

    // select * from tb_produto where categoria_id = :categoriaId
    List<Produto> findByCategoriaId(Long categoriaId);
}
