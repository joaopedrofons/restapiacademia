package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Aluno;
import repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAluno(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}