package dio.springperson.mts.entity.beneficiario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_BENEFICIARIO")
@Getter
@Setter
@NoArgsConstructor
public class Beneficiario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataDeNascimento;

    public Beneficiario(Long id, String nome, String sobrenome, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
    }
}
