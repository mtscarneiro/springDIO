package dio.springperson.mts.entity.beneficiario;

import dio.springperson.mts.exceptions.ConteudoNaoExistenteException;
import dio.springperson.mts.exceptions.ViolacaoDeBancoDeDadosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConsultaDeBeneficiario implements IConsultadorDeBenficiario {

    private BeneficiarioRepositorio beneficiarioRepositorio;

    @Autowired
    public ConsultaDeBeneficiario(BeneficiarioRepositorio beneficiarioRepositorio) {
        this.beneficiarioRepositorio = beneficiarioRepositorio;
    }

    @Override
    public List<Beneficiario> acharTodos() {
        return beneficiarioRepositorio.findAll();
    }

    @Override
    public Beneficiario acharBeneficiarioPor(String id) {
        return beneficiarioRepositorio.getById(id);
    }

    @Override
    public Beneficiario inserirBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepositorio.save(beneficiario);
    }

    @Override
    public void deletarBeneficiarioPor(String id) {
        try {
            beneficiarioRepositorio.deleteById(id);
        } catch (DataIntegrityViolationException err) {
            throw new ViolacaoDeBancoDeDadosException(err.getMessage());
        } catch (EmptyResultDataAccessException err) {
            throw new ConteudoNaoExistenteException(id);
        }
    }

    @Override
    public Beneficiario atualizarCadastroBeneficiario(String id, Beneficiario beneficiario) {
        try {
            Beneficiario benef = beneficiarioRepositorio.getById(id);
            atualizacaoCadastral(benef, beneficiario);
            return beneficiarioRepositorio.save(benef);
        }  catch (EntityNotFoundException err) {
            throw new ConteudoNaoExistenteException(id);
        }
    }

    private void atualizacaoCadastral(Beneficiario benef, Beneficiario beneficiario) {
        benef.setNome(beneficiario.getNome());
        benef.setSobrenome(beneficiario.getSobrenome());
        benef.setDataDeNascimento(beneficiario.getDataDeNascimento());
    }
}
