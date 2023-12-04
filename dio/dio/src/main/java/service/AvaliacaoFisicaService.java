package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.AvaliacaoFisica;
import repository.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
    }

    public List<AvaliacaoFisica> getAvaliacoesFisicas() {
        return avaliacaoFisicaRepository.findAll();
    }

    public AvaliacaoFisica getAvaliacaoFisica(Long id) {
        return avaliacaoFisicaRepository.findById(id).orElse(null);
    }

    public AvaliacaoFisica saveAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public void deleteAvaliacaoFisica(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}