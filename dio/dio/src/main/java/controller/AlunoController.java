package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Aluno;
import service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos() {
        List<Aluno> alunos = alunoService.getAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.getAluno(id);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
        Aluno savedAluno = alunoService.saveAluno(aluno);
        return new ResponseEntity<>(savedAluno, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}