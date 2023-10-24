package cadastrouser.api.View.Model;

import lombok.Data;

@Data
public class UsuarioRequest {
    private Long id;
    private String username;
    private String name;
    private String email;
}
