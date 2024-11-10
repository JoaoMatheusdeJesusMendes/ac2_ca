package ac2_ca_project.ac2_ca.dto;

public class CursoDTO {
    private Long id;
    private String nomeCurso;
    private float media;
    private String professor;
    private String materia;
    private boolean finalizouCurso;

    public CursoDTO() {}

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

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public boolean isFinalizouCurso() {
        return finalizouCurso;
    }

    public void setFinalizouCurso(boolean finalizouCurso) {
        this.finalizouCurso = finalizouCurso;
    }
}
