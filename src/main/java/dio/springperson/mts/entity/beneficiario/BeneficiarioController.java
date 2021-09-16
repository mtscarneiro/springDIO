package dio.springperson.mts.entity.beneficiario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/beneficiario")
public class BeneficiarioController {

    @Autowired
    private ConsultaDeBeneficiario consultaDeBeneficiario;

    @GetMapping("/todos")
    public ResponseEntity<List<Beneficiario>> acharTodos() {
        List<Beneficiario> lista = consultaDeBeneficiario.acharTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> acharBeneficiarioPorID(@PathVariable Long id) {
        Beneficiario beneficiario = consultaDeBeneficiario.acharBeneficiarioPor(id);
        return ResponseEntity.ok().body(beneficiario);
    }

    @PostMapping(value = "/inserir-beneficiario")
    public ResponseEntity<Beneficiario> inserirBeneficiario(@RequestBody Beneficiario beneficiario) {
        beneficiario = consultaDeBeneficiario.inserirBeneficiario(beneficiario);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("employees/{id}")
                .buildAndExpand(beneficiario.getId()).toUri();
        return ResponseEntity.created(uri).body(beneficiario);
    }

    @DeleteMapping(value = "/deletar-{id}")
    public ResponseEntity<Beneficiario> deletarBeneficiario(@PathVariable Long id) {
        consultaDeBeneficiario.deletarBeneficiarioPor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/atualizar-{id}")
    public ResponseEntity<Beneficiario> atualizarDadosDoBeneficiario(@PathVariable Long id,
                                                                     @RequestBody Beneficiario beneficiario) {
        beneficiario = consultaDeBeneficiario.atualizarCadastroBeneficiario(id, beneficiario);
        return ResponseEntity.ok().body(beneficiario);
    }
}
