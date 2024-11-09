package ac2_ca_project.ac2_ca.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Professor {

    private String professor;

    protected Professor() {
    }
    
    public Professor(String professor) {
    	if (professor == null) {
        	throw new IllegalArgumentException("O nome do professor não pode ser nulo.");
        }
        this.professor = professor;
    }

    public String getProfessor() {
        return professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor1 = (Professor) o;
        return Objects.equals(professor, professor1.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor);
    }

    @Override
    public String toString() {
        return professor;
    }
}
