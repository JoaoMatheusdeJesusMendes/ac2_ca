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
import ac2_ca_project.ac2_ca.entity.Email;
import ac2_ca_project.ac2_ca.entity.Ra;
import ac2_ca_project.ac2_ca.entity.Usuario;
import ac2_ca_project.ac2_ca.repository.UsuarioRepository;

@ActiveProfiles("test")
@ContextConfiguration(classes = Ac2CaApplication.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testSaveAndFindUsuarioWithRaAndEmail() {
        Usuario usuario = new Usuario();
        usuario.setNome("testUsuario");
        usuario.setRa(new Ra("123456"));
        usuario.setEmail(new Email("test@example.com"));

        Usuario usuarioSaved = usuarioRepository.save(usuario);
        assertNotNull(usuarioSaved.getId(), "O ID do usuário salvo deve ser gerado.");

        Optional<Usuario> retrievedUser = usuarioRepository.findById(usuarioSaved.getId());
        assertTrue(retrievedUser.isPresent(), "O usuário deve estar presente no banco de dados.");
        assertEquals("testUsuario", retrievedUser.get().getNome());
        assertEquals("123456", retrievedUser.get().getRa().getRa(), "O RA deve corresponder.");
        assertEquals("test@example.com", retrievedUser.get().getEmail().getEmail(), "O email deve corresponder.");
    }
}
