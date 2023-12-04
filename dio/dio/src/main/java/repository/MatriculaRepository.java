package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}