package ac2_ca_project.ac2_ca.service;

import ac2_ca_project.ac2_ca.dto.CursoDTO;
import ac2_ca_project.ac2_ca.entity.Curso;
import ac2_ca_project.ac2_ca.entity.FinalizouCurso;
import ac2_ca_project.ac2_ca.entity.Materia;
import ac2_ca_project.ac2_ca.entity.Professor;
import ac2_ca_project.ac2_ca.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoDTO salvar(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNomeCurso(cursoDTO.getNomeCurso());
        curso.setMedia(cursoDTO.getMedia());
        curso.setProfessor(new Professor(cursoDTO.getProfessor()));
        curso.setMateria(new Materia(cursoDTO.getMateria()));
        curso.setFinalizouCurso(new FinalizouCurso(cursoDTO.isFinalizouCurso()));

        Curso cursoSalvo = cursoRepository.save(curso);
        cursoDTO.setId(cursoSalvo.getId());
        return cursoDTO;
    }

    public List<CursoDTO> listarTodos() {
        return cursoRepository.findAll().stream().map(curso -> {
            CursoDTO dto = new CursoDTO();
            dto.setId(curso.getId());
            dto.setNomeCurso(curso.getNomeCurso());
            dto.setMedia(curso.getMedia());
            dto.setProfessor(curso.getProfessor().getProfessor());
            dto.setMateria(curso.getMateria().getMateria());
            dto.setFinalizouCurso(curso.getFinalizouCurso().getFinalizoucurso());
            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<CursoDTO> buscarPorId(Long id) {
        return cursoRepository.findById(id).map(curso -> {
            CursoDTO dto = new CursoDTO();
            dto.setId(curso.getId());
            dto.setNomeCurso(curso.getNomeCurso());
            dto.setMedia(curso.getMedia());

            dto.setProfessor(curso.getProfessor().getProfessor());
            dto.setMateria(curso.getMateria().getMateria());
            dto.setFinalizouCurso(curso.getFinalizouCurso().getFinalizoucurso());
            return dto;
        });
    }

    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }
}
