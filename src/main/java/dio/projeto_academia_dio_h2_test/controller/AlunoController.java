package dio.projeto_academia_dio_h2_test.controller;


import dio.projeto_academia_dio_h2_test.entity.Aluno;
import dio.projeto_academia_dio_h2_test.entity.AvaliacaoFisica;
import dio.projeto_academia_dio_h2_test.entity.form.AlunoForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dio.projeto_academia_dio_h2_test.service.impl.AlunoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

        @Autowired
        private AlunoServiceImpl service;

        @PostMapping
        public Aluno create(@Valid @RequestBody AlunoForm form) {
            return service.create(form);
        }

        @GetMapping("/avaliacoes/{id}")
        public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
            return service.getAllAvaliacaoFisicaId(id);
        }

        @GetMapping
        public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
            return service.getAll(dataDeNacimento);
        }

}
