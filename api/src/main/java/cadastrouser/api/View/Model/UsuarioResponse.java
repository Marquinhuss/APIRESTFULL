package cadastrouser.api.View.Model;

import lombok.Data;

@Data
public class UsuarioResponse {
    private Long id;
    private String username;
    private String name;
    private String email;
}
