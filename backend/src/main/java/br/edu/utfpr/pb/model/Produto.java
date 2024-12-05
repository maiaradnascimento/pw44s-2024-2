package br.edu.utfpr.pb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do produto não pode ser nulo.")
    @Size(min = 2, max = 100)
    private String nome;

    @Size(max = 255)
    private String descricao;

    @NotNull(message = "O preço do produto não pode ser nulo.")
    private BigDecimal preco;

    private String urlImagem;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
