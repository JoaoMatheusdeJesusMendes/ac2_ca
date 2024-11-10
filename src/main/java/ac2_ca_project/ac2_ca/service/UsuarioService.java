package ac2_ca_project.ac2_ca.service;

import ac2_ca_project.ac2_ca.dto.UsuarioDTO;
import ac2_ca_project.ac2_ca.entity.Email;
import ac2_ca_project.ac2_ca.entity.Ra;
import ac2_ca_project.ac2_ca.entity.Usuario;
import ac2_ca_project.ac2_ca.repository.CursoRepository;
import ac2_ca_project.ac2_ca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setRa(new Ra(usuarioDTO.getRa()));
        usuario.setEmail(new Email(usuarioDTO.getEmail()));
        
        usuario.setNumeroCursosDisponiveis(usuarioDTO.getNumeroCursosDisponiveis());
        cursoRepository.findById(usuarioDTO.getCursoId()).ifPresent(usuario::setCurso);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        usuarioDTO.setId(usuarioSalvo.getId());
        return usuarioDTO;
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream().map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(usuario.getId());
            dto.setNome(usuario.getNome());
            dto.setRa(usuario.getRa().getRa());
            dto.setEmail(usuario.getEmail().getEmail());
            
            dto.setNumeroCursosDisponiveis(usuario.getNumeroCursosDisponiveis());
            dto.setCursoId(usuario.getCurso().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> buscarPorId(Long id) {
        return usuarioRepository.findById(id).map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(usuario.getId());
            dto.setNome(usuario.getNome());
            dto.setRa(usuario.getRa().getRa());
            dto.setEmail(usuario.getEmail().getEmail());
            
            dto.setNumeroCursosDisponiveis(usuario.getNumeroCursosDisponiveis());
            dto.setCursoId(usuario.getCurso().getId());
            return dto;
        });
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
