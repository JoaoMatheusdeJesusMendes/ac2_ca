package ac2_ca_project.ac2_ca.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {

    private String email;

    protected Email() {
    }

    public Email(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) { // Validação básica de email
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }
}
