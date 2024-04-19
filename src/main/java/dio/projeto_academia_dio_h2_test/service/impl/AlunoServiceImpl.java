package dio.projeto_academia_dio_h2_test.service.impl;

import dio.projeto_academia_dio_h2_test.entity.Aluno;
import dio.projeto_academia_dio_h2_test.entity.AvaliacaoFisica;
import dio.projeto_academia_dio_h2_test.entity.form.AlunoForm;
import dio.projeto_academia_dio_h2_test.entity.form.AlunoUpdateForm;
import dio.projeto_academia_dio_h2_test.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dio.projeto_academia_dio_h2_test.repository.AlunoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado para id: " + id));
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimentoS) {
        if (dataDeNascimentoS != null && !dataDeNascimentoS.isEmpty()){
            LocalDate dataDeNascimento = LocalDate.parse(dataDeNascimentoS, DateTimeFormatter.BASIC_ISO_DATE);
            return alunoRepository.findAllByAlunoDataDeNascimento(dataDeNascimento);
        } else {
            return alunoRepository.findAll();
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado para id: " + id));
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado para id: " + id));
        alunoRepository.deleteById(id);

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado para id: " + id));
        return aluno.getAvaliacoes();
    }
}
