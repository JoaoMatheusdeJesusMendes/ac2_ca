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

import ac2_ca_project.ac2_ca.controller.CursoController;
import ac2_ca_project.ac2_ca.dto.CursoDTO;
import ac2_ca_project.ac2_ca.service.CursoService;

@WebMvcTest(CursoController.class) // Carrega apenas o contexto da camada web
public class CursoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoService cursoService; // Injeta um mock do serviço, substituindo a necessidade do repositório

    @Test
    public void testGetUsers() throws Exception {
        // Configura o comportamento do mock para o método de serviço
        CursoDTO mockCurso = new CursoDTO();
        mockCurso.setId(1L);
        mockCurso.setNomeCurso("Matematica");
        mockCurso.setProfessor("Fernando");
        mockCurso.setMateria("Matematica");
        mockCurso.setFinalizouCurso(true);
        
        List<CursoDTO> mockCursos = List.of(mockCurso);
        Mockito.when(cursoService.listarTodos()).thenReturn(mockCursos);

        // Realiza a requisição e verifica a resposta
        mockMvc.perform(MockMvcRequestBuilders.get("/cursos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomeCurso").value("Matematica"))
                .andExpect(jsonPath("$[0].professor").value("Fernando"))
                .andExpect(jsonPath("$[0].materia").value("Matematica"))
                .andExpect(jsonPath("$[0].finalizouCurso").value(true));
    }
}
