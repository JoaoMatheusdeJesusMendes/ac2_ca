package ac2_ca_project.ac2_ca.entity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
	private String nome;
	@Embedded
	private Ra ra;
	@Embedded
	private Email email;
	private int numeroCursosDisponiveis;
	@ManyToOne
	private Curso curso;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, Ra ra, Email email) {
		this.nome = nome;
		this.ra = ra;
		this.email = email;
	}
	
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
	
	public int getNumeroCursosDisponiveis() {
		return numeroCursosDisponiveis;
	}
	
	public void setNumeroCursosDisponiveis(int numeroCursosDisponiveis) {
		this.numeroCursosDisponiveis = numeroCursosDisponiveis;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public Ra getRa() {
		return ra;
	}

	public void setRa(Ra ra) {
		this.ra = ra;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}	
	
	public void disponibilizaCursoPorMedia() {
		if(this.curso.getMedia() >= 7 && this.curso.getFinalizouCurso().getFinalizoucurso() == true) {
			this.numeroCursosDisponiveis += 3;
		}
	}


}
