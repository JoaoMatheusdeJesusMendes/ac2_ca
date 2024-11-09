package ac2_ca_project.ac2_ca.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Materia {

    private String materia;

    protected Materia() {
    }
    
    public Materia(String materia) {
    	if (materia == null) {
        	throw new IllegalArgumentException("O nome da materia não pode ser nulo.");
        }
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia1 = (Materia) o;
        return Objects.equals(materia, materia1.materia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materia);
    }

    @Override
    public String toString() {
        return materia;
    }
}
