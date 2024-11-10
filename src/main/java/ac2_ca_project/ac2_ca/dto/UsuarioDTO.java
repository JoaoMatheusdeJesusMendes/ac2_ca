package ac2_ca_project.ac2_ca.dto;

import ac2_ca_project.ac2_ca.entity.Curso;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String ra;
    private String email;
    private int numeroCursosDisponiveis;
    private Long cursoId;

    public UsuarioDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroCursosDisponiveis() {
        return numeroCursosDisponiveis;
    }

    public void setNumeroCursosDisponiveis(int numeroCursosDisponiveis) {
        this.numeroCursosDisponiveis = numeroCursosDisponiveis;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
