package ac2_project.ac2_ca.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ac2_ca_project.ac2_ca.entity.Email;
import ac2_ca_project.ac2_ca.entity.Ra;
import ac2_ca_project.ac2_ca.entity.Usuario;
import ac2_ca_project.ac2_ca.repository.UsuarioRepository;



@ActiveProfiles("test")
@DataJpaTest
public class UsuarioRepositoryTest {
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testSaveAndFindUser() {
        //Cria um objeto User com um email válido
        Usuario usuario = new Usuario();
        usuario.setNome("testUsuario");
        usuario.setRa(new Ra("123456"));
        usuario.setEmail(new Email("test@example.com"));

         //Salva no banco de dados
         Usuario usuarioSaved = usuarioRepository.save(usuario);
        assertNotNull(usuarioSaved.getId());  // Verifica se o ID foi gerado

        // Busca o usuário pelo ID
        Optional<Usuario> retrievedUser = usuarioRepository.findById(usuarioSaved.getId());
        assertTrue(retrievedUser.isPresent());
        assertEquals("testUsuario", retrievedUser.get().getNome());
   }

}
