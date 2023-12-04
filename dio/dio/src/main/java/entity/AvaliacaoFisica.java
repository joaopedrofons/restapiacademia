package entity;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AvaliacaoFisica {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "aluno_id", nullable = false)
	    private Aluno aluno;

	    private LocalDate data;

	    private double peso;

	    private double altura;

	    // Adicione outros campos conforme necessário

	    // Getters e setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Aluno getAluno() {
	        return aluno;
	    }

	    public void setAluno(Aluno aluno) {
	        this.aluno = aluno;
	    }

	    public LocalDate getData() {
	        return data;
	    }

	    public void setData(LocalDate data) {
	        this.data = data;
	    }

	    public double getPeso() {
	        return peso;
	    }

	    public void setPeso(double peso) {
	        this.peso = peso;
	    }

	    public double getAltura() {
	        return altura;
	    }

	    public void setAltura(double altura) {
	        this.altura = altura;
	    }

}
