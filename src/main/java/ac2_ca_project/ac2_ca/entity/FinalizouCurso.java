package ac2_ca_project.ac2_ca.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class FinalizouCurso {

    private Boolean finalizoucurso;

    protected FinalizouCurso() {
    }

    public FinalizouCurso(Boolean finalizoucurso) {
        if (finalizoucurso == null) {
            throw new IllegalArgumentException("O valor de finalizoucurso não pode ser nulo.");
        }
        this.finalizoucurso = finalizoucurso;
    }

    public Boolean getFinalizoucurso() {
        return finalizoucurso;
    }

    public void setFinalizoucurso(Boolean finalizoucurso) {
        if (finalizoucurso == null) {
            throw new IllegalArgumentException("O valor de finalizoucurso não pode ser nulo.");
        }
        this.finalizoucurso = finalizoucurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalizouCurso that = (FinalizouCurso) o;
        return Objects.equals(finalizoucurso, that.finalizoucurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalizoucurso);
    }

    @Override
    public String toString() {
        return Boolean.toString(finalizoucurso);
    }
}


