package ac2_project.ac2_ca.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ac2_ca_project.ac2_ca.dto.CursoDTO;
import ac2_ca_project.ac2_ca.entity.Curso;
import ac2_ca_project.ac2_ca.entity.FinalizouCurso;
import ac2_ca_project.ac2_ca.entity.Materia;
import ac2_ca_project.ac2_ca.entity.Professor;
import ac2_ca_project.ac2_ca.repository.CursoRepository;
import ac2_ca_project.ac2_ca.service.CursoService;

public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        Curso curso1 = new Curso();
        curso1.setId(1L);
        curso1.setNomeCurso("curso1");
        curso1.setProfessor(new Professor("Fernando"));
        curso1.setMateria(new Materia("Português"));
        curso1.setFinalizouCurso(new FinalizouCurso(true));

        Curso curso2 = new Curso();
        curso2.setId(2L);
        curso2.setNomeCurso("curso2");
        curso2.setProfessor(new Professor("Mauricio"));
        curso2.setMateria(new Materia("Geografia"));
        curso2.setFinalizouCurso(new FinalizouCurso(false));

        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));

        List<CursoDTO> cursos = cursoService.listarTodos();

        assertEquals(2, cursos.size());
        assertEquals("curso1", cursos.get(0).getNomeCurso());
        assertEquals("Fernando", cursos.get(0).getProfessor());
        assertEquals("Português", cursos.get(0).getMateria());
        assertEquals(true, cursos.get(0).isFinalizouCurso());
    }
}
