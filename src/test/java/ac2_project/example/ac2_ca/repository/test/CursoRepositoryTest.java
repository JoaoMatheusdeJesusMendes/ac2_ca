package ac2_project.example.ac2_ca.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ac2_ca_project.ac2_ca.entity.Curso;
import ac2_ca_project.ac2_ca.entity.FinalizouCurso;
import ac2_ca_project.ac2_ca.entity.Materia;
import ac2_ca_project.ac2_ca.entity.Professor;
import ac2_ca_project.ac2_ca.repository.CursoRepository;

/*@SpringBootTest*/
public class CursoRepositoryTest {
	/*@Autowired
    private CursoRepository cursoRepository;

    @Test
    void testSaveAndFindUser() {
        //Cria um objeto User com um email válido
        Curso curso = new Curso();
        curso.setNomeCurso("testCurso");
        curso.setMateria(new Materia("testMateria"));
        curso.setProfessor(new Professor("testProfessor"));
        curso.setMateria(new Materia("testMateria"));
        curso.setFinalizouCurso(new FinalizouCurso(true));
        
         //Salva no banco de dados
         Curso savedCurso = cursoRepository.save(curso);
        assertNotNull(savedCurso.getId());  // Verifica se o ID foi gerado

        // Busca o usuário pelo ID
        Optional<Curso> retrievedUser = cursoRepository.findById(savedCurso.getId());
        assertTrue(retrievedUser.isPresent());
        assertEquals("testCurso", retrievedUser.get().getNomeCurso());
   }*/
}
