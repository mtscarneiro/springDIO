package dio.springperson.mts.entity.beneficiario;

import dio.springperson.mts.entity.atendimento.Atendimento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "beneficiario")
    private List<Atendimento> atendimentos;

    public Beneficiario(Long id, String nome, String sobrenome, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
    }
}
