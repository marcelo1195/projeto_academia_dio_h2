package dio.projeto_academia_dio_h2_test.service.impl;

import dio.projeto_academia_dio_h2_test.entity.Aluno;
import dio.projeto_academia_dio_h2_test.entity.Matricula;
import dio.projeto_academia_dio_h2_test.entity.form.MatriculaForm;
import dio.projeto_academia_dio_h2_test.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dio.projeto_academia_dio_h2_test.repository.AlunoRepository;
import dio.projeto_academia_dio_h2_test.repository.MatriculaRepository;

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
