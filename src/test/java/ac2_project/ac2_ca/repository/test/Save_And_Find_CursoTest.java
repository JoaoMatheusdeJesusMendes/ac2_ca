package ac2_project.ac2_ca.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import ac2_ca_project.ac2_ca.entity.Curso;
import ac2_ca_project.ac2_ca.repository.CursoRepository;

@ActiveProfiles("test")
@DataJpaTest
public class Save_And_Find_CursoTest {
	@Autowired
    private CursoRepository cursoRepository;

    @Test
    public void testSaveAndFindUser() {
        // Cria um novo usuário
        Curso curso = new Curso();
        curso.setNomeCurso("testCurso1");

        // Salva no banco de dados
        Curso savedCurso = cursoRepository.save(curso);
        assertNotNull(savedCurso.getId());
        // Busca o usuário pelo ID
        Optional<Curso> retrievedCurso = cursoRepository.findById(savedCurso.getId());
        assertThat(retrievedCurso).isPresent();
        assertThat(retrievedCurso.get().getNomeCurso()).isEqualTo("testCurso1");
	    }
}
