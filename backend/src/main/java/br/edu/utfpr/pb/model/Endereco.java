package br.edu.utfpr.pb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tb_endereco")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @NotNull
    @Size(min = 3, max = 100)
    private String logradouro;

    private String complemento;

    @NotNull
    @Size(min = 8, max = 10)
    private String cep;
}
