package dio.springperson.mts.entity.beneficiario;

import java.util.List;

public interface IConsultadorDeBenficiario {

    List<Beneficiario> acharTodos();

    Beneficiario acharBeneficiarioPor(String id);

    Beneficiario inserirBeneficiario(Beneficiario beneficiario);

    void deletarBeneficiarioPor(String id);

    Beneficiario atualizarCadastroBeneficiario(String id, Beneficiario beneficiario);
}
