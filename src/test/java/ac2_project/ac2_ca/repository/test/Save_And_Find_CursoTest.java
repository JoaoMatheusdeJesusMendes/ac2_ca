package ac2_project.ac2_ca.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import ac2_ca_project.ac2_ca.Ac2CaApplication;
import ac2_ca_project.ac2_ca.entity.Curso;
import ac2_ca_project.ac2_ca.repository.CursoRepository;

@ActiveProfiles("test")
@ContextConfiguration(classes = Ac2CaApplication.class)
@DataJpaTest
public class Save_And_Find_CursoTest {
	@Autowired
    private CursoRepository cursoRepository;

    @Test
    public void testSaveAndFindCurso() {
        // Cria e configura um novo objeto Curso
        Curso curso = new Curso();
        curso.setNomeCurso("testCurso1");
        // Adicione outros atributos necessários aqui, se aplicável

        // Salva o curso no banco de dados
        Curso savedCurso = cursoRepository.save(curso);
        assertNotNull(savedCurso.getId(), "O ID do curso salvo deve ser gerado.");

        // Busca o curso pelo ID
        Optional<Curso> retrievedCurso = cursoRepository.findById(savedCurso.getId());
        assertThat(retrievedCurso).isPresent();
        assertThat(retrievedCurso.get().getNomeCurso()).isEqualTo("testCurso1");
    }
}
