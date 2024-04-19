package dio.projeto_academia_dio_h2_test.service.impl;

import dio.projeto_academia_dio_h2_test.entity.Aluno;
import dio.projeto_academia_dio_h2_test.entity.AvaliacaoFisica;
import dio.projeto_academia_dio_h2_test.entity.form.AvaliacaoFisicaForm;
import dio.projeto_academia_dio_h2_test.entity.form.AvaliacaoFisicaUpdateForm;
import dio.projeto_academia_dio_h2_test.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dio.projeto_academia_dio_h2_test.repository.AlunoRepository;
import dio.projeto_academia_dio_h2_test.repository.AvaliacaoFisicaReposiroty;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaReposiroty avaliacaoFisicaReposiroty;

    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setImcAtual(avaliacaoFisica.getImcAtual());
        return avaliacaoFisicaReposiroty.save(avaliacaoFisica);
    }


    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoFisicaReposiroty.findById(id)
                .orElseThrow(()-> new RuntimeException("Avaliação fisica não endontrada para id: " + id));
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaReposiroty.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaReposiroty.findById(id)
                .orElseThrow(()-> new RuntimeException("Avaliação fisica não endontrada para id: " + id));
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        return avaliacaoFisicaReposiroty.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaReposiroty.findById(id)
                .orElseThrow(()-> new RuntimeException("Avaliação fisica não endontrada para id: " + id));
        avaliacaoFisicaReposiroty.deleteById(id);
    }
}
