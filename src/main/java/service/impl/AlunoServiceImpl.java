package service.impl;

import entity.Aluno;
import entity.AvaliacaoFisica;
import entity.form.AlunoForm;
import entity.form.AlunoUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlunoRepository;
import service.IAlunoService;

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

        return null;
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        return List.of();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        return List.of();
    }
}
