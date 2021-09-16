package dio.springperson.mts.beneficiario;

import com.github.javafaker.Faker;
import dio.springperson.mts.entity.beneficiario.Beneficiario;
import dio.springperson.mts.entity.beneficiario.BeneficiarioRepositorio;
import dio.springperson.mts.entity.beneficiario.ConsultaDeBeneficiario;
import dio.springperson.mts.entity.beneficiario.IConsultadorDeBenficiario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AdicaoDeBeneficiarioTest {
    private Faker faker;

    @Mock
    private IConsultadorDeBenficiario consultadorDeBeneficiario;

    @Mock
    private BeneficiarioRepositorio beneficiarioRepositorio;

    @BeforeEach
    void init() {
        consultadorDeBeneficiario = new ConsultaDeBeneficiario(beneficiarioRepositorio);
    }

    private List<Beneficiario> criarListaDeBeneficiarios() {
        Beneficiario beneficiarioUm = criarBeneficiario();
        Beneficiario beneficiarioDois = criarBeneficiario();
        List<Beneficiario> lista = Arrays.asList(beneficiarioUm, beneficiarioDois);
        return lista;
    }

    private Beneficiario criarBeneficiario() {
        Beneficiario beneficiario = new Beneficiario(faker.leagueOfLegends().location(),
                faker.leagueOfLegends().champion(),
                faker.leagueOfLegends().masteries(),
                LocalDate.now());
        return beneficiario;
    }

    @Test
    void deveAdicionarBeneficiarioCorretamente() {
        List<Beneficiario> listaDeBeneficiarios = criarListaDeBeneficiarios();

        Mockito.when(beneficiarioRepositorio.findAll()).thenReturn(listaDeBeneficiarios);

        Mockito.when(consultadorDeBeneficiario.acharTodos()).thenReturn(listaDeBeneficiarios);

        Assertions.assertTrue(consultadorDeBeneficiario.acharTodos() != null);
    }

}
