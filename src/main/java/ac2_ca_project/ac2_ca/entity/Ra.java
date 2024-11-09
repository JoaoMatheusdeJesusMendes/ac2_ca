package ac2_ca_project.ac2_ca.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Ra {

    private String ra;

    protected Ra() {
    }
    
    public Ra(String ra) {
        if (ra == null || !ra.matches("\\d{6}")) {
            throw new IllegalArgumentException("RA inválido. Deve conter 6 dígitos numéricos.");
        }
        this.ra = ra;
    }

    public String getRa() {
        return ra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ra ra1 = (Ra) o;
        return Objects.equals(ra, ra1.ra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ra);
    }

    @Override
    public String toString() {
        return ra;
    }
}
