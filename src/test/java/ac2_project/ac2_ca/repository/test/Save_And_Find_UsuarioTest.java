package ac2_project.ac2_ca.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import ac2_ca_project.ac2_ca.entity.Usuario;
import ac2_ca_project.ac2_ca.repository.UsuarioRepository;


@ActiveProfiles("test")
@DataJpaTest
public class Save_And_Find_UsuarioTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testSaveAndFindUsuario() {
        // Cria e configura um novo objeto Usuario
        Usuario usuario = new Usuario();
        usuario.setNome("testUsuario1");
        // Adicione outros atributos necessários aqui, se aplicável

        // Salva o usuário no banco de dados
        Usuario savedUsuario = usuarioRepository.save(usuario);
        assertNotNull(savedUsuario.getId(), "O ID do usuário salvo deve ser gerado.");

        // Busca o usuário pelo ID
        Optional<Usuario> retrievedUsuario = usuarioRepository.findById(savedUsuario.getId());
        assertThat(retrievedUsuario).isPresent();
        assertThat(retrievedUsuario.get().getNome()).isEqualTo("testUsuario1");
    }
}
