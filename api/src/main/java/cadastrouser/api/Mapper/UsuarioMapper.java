package cadastrouser.api.Mapper;

import org.mapstruct.Mapper;

import cadastrouser.api.Model.Usuario;
import cadastrouser.api.Shared.UsuarioDTO;
import cadastrouser.api.View.Model.UsuarioRequest;
import cadastrouser.api.View.Model.UsuarioResponse;

@Mapper
public interface UsuarioMapper {
    
    Usuario toEntity(UsuarioDTO usuarioDto);
    UsuarioDTO toUsuarioDTO(Usuario usuario);

    UsuarioResponse toResponse(UsuarioDTO usuarioDto);
    UsuarioDTO fromRequest(UsuarioRequest usuarioRequest);

}
