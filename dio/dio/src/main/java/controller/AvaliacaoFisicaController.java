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

import entity.AvaliacaoFisica;
import service.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoesfisicas")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @Autowired
    public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService) {
        this.avaliacaoFisicaService = avaliacaoFisicaService;
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> getAvaliacoesFisicas() {
        List<AvaliacaoFisica> avaliacoesFisicas = avaliacaoFisicaService.getAvaliacoesFisicas();
        return new ResponseEntity<>(avaliacoesFisicas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> getAvaliacaoFisica(@PathVariable Long id) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.getAvaliacaoFisica(id);
        return new ResponseEntity<>(avaliacaoFisica, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> saveAvaliacaoFisica(@RequestBody AvaliacaoFisica avaliacaoFisica) {
        AvaliacaoFisica savedAvaliacaoFisica = avaliacaoFisicaService.saveAvaliacaoFisica(avaliacaoFisica);
        return new ResponseEntity<>(savedAvaliacaoFisica, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvaliacaoFisica(@PathVariable Long id) {
        avaliacaoFisicaService.deleteAvaliacaoFisica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}