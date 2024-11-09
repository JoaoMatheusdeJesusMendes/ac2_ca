package ac2_ca_project.ac2_ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ac2_ca_project.ac2_ca.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
