package dio.springperson.mts.entity.atendimento;


import dio.springperson.mts.entity.beneficiario.Beneficiario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_ATENDIMENTO")
@Getter
@Setter
@NoArgsConstructor
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    private List<Evento> eventos;

    public Atendimento(Long id, Beneficiario beneficiario, List<Evento> eventos) {
        this.id = id;
        this.beneficiario = beneficiario;
        this.eventos = eventos;
    }
}
