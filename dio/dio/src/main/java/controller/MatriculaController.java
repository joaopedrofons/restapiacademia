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

import entity.Matricula;
import service.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @Autowired
    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getMatriculas() {
        List<Matricula> matriculas = matriculaService.getMatriculas();
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getMatricula(@PathVariable Long id) {
        Matricula matricula = matriculaService.getMatricula(id);
        return new ResponseEntity<>(matricula, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Matricula> saveMatricula(@RequestBody Matricula matricula) {
        Matricula savedMatricula = matriculaService.saveMatricula(matricula);
        return new ResponseEntity<>(savedMatricula, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatricula(@PathVariable Long id) {
        matriculaService.deleteMatricula(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
