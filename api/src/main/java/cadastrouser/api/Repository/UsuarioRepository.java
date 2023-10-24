package cadastrouser.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cadastrouser.api.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Long>{
}
