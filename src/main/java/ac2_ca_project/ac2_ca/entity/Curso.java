package ac2_ca_project.ac2_ca.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
		private String nomeCurso;
		private float media;
		@Embedded
		private Professor professor;
		@Embedded
		private Materia materia;
		@Embedded
		private FinalizouCurso finalizouCurso;

	public Curso() {
	}

	public Curso(String nomeCurso, float media, FinalizouCurso finalizouCurso, Professor professor, Materia materia){
		this.nomeCurso = nomeCurso;
		this.media = media;
		this.finalizouCurso =  finalizouCurso;
		this.professor = professor;
		this.materia = materia;
	}
	 
	public Long getId() {
	    return id;
	}

    public void setId(Long id) {
        this.id = id;
    }

	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public FinalizouCurso getFinalizouCurso() {
		return finalizouCurso;
	}
	
	public void setFinalizouCurso(FinalizouCurso finalizouCurso) {
		this.finalizouCurso = finalizouCurso;
	}
	
	public float getMedia() {
		return media;
	}
	
	public void setMedia(float media) {
		this.media = media;
	}
	
	

}
