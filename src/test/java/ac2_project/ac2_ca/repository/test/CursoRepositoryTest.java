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
@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    void testSaveAndFindCurso() {
        Materia materia = new Materia("testMateria");
        Professor professor = new Professor("testProfessor");
        FinalizouCurso finalizouCurso = new FinalizouCurso(true);

        Curso curso = new Curso();
        curso.setNomeCurso("testCurso");
        curso.setMateria(materia);
        curso.setProfessor(professor);
        curso.setFinalizouCurso(finalizouCurso);

        Curso savedCurso = cursoRepository.save(curso);
        assertNotNull(savedCurso.getId());

        Optional<Curso> retrievedCurso = cursoRepository.findById(savedCurso.getId());
        assertTrue(retrievedCurso.isPresent());
        assertEquals("testCurso", retrievedCurso.get().getNomeCurso());
    }
}

