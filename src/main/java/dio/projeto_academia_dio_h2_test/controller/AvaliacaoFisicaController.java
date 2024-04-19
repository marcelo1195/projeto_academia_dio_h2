package dio.projeto_academia_dio_h2_test.controller;

import dio.projeto_academia_dio_h2_test.entity.AvaliacaoFisica;
import dio.projeto_academia_dio_h2_test.entity.form.AvaliacaoFisicaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dio.projeto_academia_dio_h2_test.service.impl.AvaliacaoFisicaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

}