package cadastrouser.api.Shared;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String username;
    private String name;
    private String email;
}
