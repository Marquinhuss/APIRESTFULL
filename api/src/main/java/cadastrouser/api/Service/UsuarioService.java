package cadastrouser.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cadastrouser.api.Model.Usuario;
import cadastrouser.api.Repository.UsuarioRepository;
import cadastrouser.api.Shared.UsuarioDTO;
import cadastrouser.api.Exception.UserNotFoundExeception;
import cadastrouser.api.Mapper.UsuarioMapper;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepositorio;

    @Autowired
    UsuarioMapper mapper;

    // getAll getById create delete update

    public List<UsuarioDTO> getAll(){
        List<Usuario> lista = usuarioRepositorio.findAll();
        List<UsuarioDTO> listaDto = new ArrayList<>();
        for (Usuario usuario : lista) {
            UsuarioDTO dto = mapper.toUsuarioDTO(usuario);
            listaDto.add(dto);
        }
        return listaDto;
    }


    public Optional<UsuarioDTO> getById(Long id){
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        if(usuario.isEmpty()){
            throw new UserNotFoundExeception("O usuario com id "+ id + " nao foi encontrado");
        }
        UsuarioDTO usuarioDto = mapper.toUsuarioDTO(usuario.get());

        return Optional.of(usuarioDto);
    }
    
    public UsuarioDTO create(UsuarioDTO usuarioDto){
        Usuario usuario = mapper.toEntity(usuarioDto);
        usuarioRepositorio.save(usuario);
        usuarioDto.setId(usuario.getId());
        return usuarioDto;
    }

    public void delete(Long id){
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        if(usuario.isEmpty()){
            throw new UserNotFoundExeception("Não foi possível encontrar o usuario com id " + id + " pois o usuario não existe");
        }
        usuarioRepositorio.delete(usuario.get());
    }

    public UsuarioDTO update(UsuarioDTO usuarioDTO, Long Id){
        Usuario usuario = mapper.toEntity(usuarioDTO);
        usuario.setId(Id);
        usuarioRepositorio.save(usuario);
        usuarioDTO.setId(Id);
        return usuarioDTO;
    }
}
