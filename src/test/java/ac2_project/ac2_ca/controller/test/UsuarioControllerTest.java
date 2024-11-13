package ac2_project.ac2_ca.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ac2_ca_project.ac2_ca.controller.UsuarioController;
import ac2_ca_project.ac2_ca.dto.UsuarioDTO;
import ac2_ca_project.ac2_ca.service.UsuarioService;

@WebMvcTest(UsuarioController.class) // Carrega apenas o contexto da camada web
public class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService; // Injeta um mock do serviço, substituindo a necessidade do repositório

    @Test
    public void testGetUsers() throws Exception {
        // Configura o comportamento do mock para o método de serviço
        UsuarioDTO mockUsuario = new UsuarioDTO();
        mockUsuario.setId(1L);
        mockUsuario.setNome("JohnDoe");
        mockUsuario.setEmail("john@example.com");
        mockUsuario.setRa("123456");
        
        List<UsuarioDTO> mockUsuarios = List.of(mockUsuario);
        Mockito.when(usuarioService.listarTodos()).thenReturn(mockUsuarios);

        // Realiza a requisição e verifica a resposta
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios") // Corrige o caminho da URL
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("JohnDoe")) // Corrige o nome do campo
                .andExpect(jsonPath("$[0].email").value("john@example.com"))
                .andExpect(jsonPath("$[0].ra").value("123456"));
    }
}
