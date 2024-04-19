package dio.projeto_academia_dio_h2_test.controller;

import dio.projeto_academia_dio_h2_test.entity.Matricula;
import dio.projeto_academia_dio_h2_test.entity.form.MatriculaForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dio.projeto_academia_dio_h2_test.service.impl.MatriculaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

}