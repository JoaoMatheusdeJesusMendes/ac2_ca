package ac2_project.ac2_ca.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import ac2_ca_project.ac2_ca.Ac2CaApplication;
import ac2_ca_project.ac2_ca.entity.Curso;
import ac2_ca_project.ac2_ca.entity.FinalizouCurso;
import ac2_ca_project.ac2_ca.entity.Materia;
import ac2_ca_project.ac2_ca.entity.Professor;
import ac2_ca_project.ac2_ca.repository.CursoRepository;

@ActiveProfiles("test")
@ContextConfiguration(classes = Ac2CaApplication.class)
@DataJpaTest // Esta anotação é suficiente para testes de repositórios
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    void testSaveAndFindCurso() {
        // Criação de entidades auxiliares (supondo que são entidades JPA)
        Materia materia = new Materia("testMateria");
        Professor professor = new Professor("testProfessor");
        FinalizouCurso finalizouCurso = new FinalizouCurso(true);

        // Criação do curso
        Curso curso = new Curso();
        curso.setNomeCurso("testCurso");
        curso.setMateria(materia);
        curso.setProfessor(professor);
        curso.setFinalizouCurso(finalizouCurso);

        // Salva o curso no banco de dados
        Curso savedCurso = cursoRepository.save(curso);
        assertNotNull(savedCurso.getId());  // Verifica se o ID foi gerado

        // Busca o curso pelo ID
        Optional<Curso> retrievedCurso = cursoRepository.findById(savedCurso.getId());
        assertTrue(retrievedCurso.isPresent());
        assertEquals("testCurso", retrievedCurso.get().getNomeCurso());
    }
}

