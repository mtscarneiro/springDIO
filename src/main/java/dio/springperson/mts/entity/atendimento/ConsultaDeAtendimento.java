package dio.springperson.mts.entity.atendimento;

import dio.springperson.mts.exceptions.ConteudoNaoExistenteException;
import dio.springperson.mts.exceptions.ViolacaoDeBancoDeDadosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaDeAtendimento {
    private AtendimentoRepositorio atendimentoRepositorio;

    @Autowired
    public ConsultaDeAtendimento(AtendimentoRepositorio atendimentoRepositorio) {
        this.atendimentoRepositorio = atendimentoRepositorio;
    }

    public List<Atendimento> acharTodos() {
        return atendimentoRepositorio.findAll();
    }

    public Atendimento acharPorId(Long id) {
        Optional<Atendimento> atendimento = atendimentoRepositorio
                .findById(id);
        return atendimento.orElseThrow(() -> new ConteudoNaoExistenteException(id));
    }

    public Atendimento inserirAtendimento(Atendimento atendimento) {
        return atendimentoRepositorio.save(atendimento);
    }

    public void deletarAtendimentoPorId(Long id) {
        try {
            atendimentoRepositorio.deleteById(id);
        } catch (DataIntegrityViolationException err) {
            throw new ViolacaoDeBancoDeDadosException(err.getMessage());
        } catch (EmptyResultDataAccessException err) {
            throw new ConteudoNaoExistenteException(id);
        }
    }

    private void atualizarAtendimento(Atendimento atendimento, Atendimento atendi) {
        atendimento.setBeneficiario(atendi.getBeneficiario());
        atendimento.setEventos(atendi.getEventos());
    }

    public 
}
