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

import ac2_ca_project.ac2_ca.dto.UsuarioDTO;
import ac2_ca_project.ac2_ca.entity.Curso;
import ac2_ca_project.ac2_ca.entity.Email;
import ac2_ca_project.ac2_ca.entity.Ra;
import ac2_ca_project.ac2_ca.entity.Usuario;
import ac2_ca_project.ac2_ca.repository.UsuarioRepository;
import ac2_ca_project.ac2_ca.service.UsuarioService;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNomeCurso("Matemática");

        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("usuario1");
        usuario1.setEmail(new Email("usuario1@example.com"));
        usuario1.setRa(new Ra("123456"));
        usuario1.setCurso(curso);

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("usuario2");
        usuario2.setEmail(new Email("user2@example.com"));
        usuario2.setRa(new Ra("654321"));
        usuario2.setCurso(curso);

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        List<UsuarioDTO> usuarios = usuarioService.listarTodos();

        assertEquals(2, usuarios.size());
        assertEquals("usuario1", usuarios.get(0).getNome());
        assertEquals("usuario1@example.com", usuarios.get(0).getEmail());
        assertEquals("123456", usuarios.get(0).getRa());
        assertEquals(1L, usuarios.get(0).getCursoId());
    }

}
