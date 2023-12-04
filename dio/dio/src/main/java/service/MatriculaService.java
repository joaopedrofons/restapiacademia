package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Matricula;
import repository.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    @Autowired
    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public List<Matricula> getMatriculas() {
        return matriculaRepository.findAll();
    }

    public Matricula getMatricula(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public Matricula saveMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public void deleteMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }
}