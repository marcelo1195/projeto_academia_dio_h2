package service.impl;

import entity.Aluno;
import entity.Matricula;
import entity.form.MatriculaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.AlunoRepository;
import repository.MatriculaRepository;
import service.IMatriculaService;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Matricula não encontrada com este id: " + id));
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro != null && !bairro.isEmpty()) {
            return matriculaRepository.findAllByAlunoBairro(bairro);
        } else {
            return matriculaRepository.findAll();
        }
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Matricula não encontrada com este id: \" + id"));
        matriculaRepository.deleteById(id);

    }
}
