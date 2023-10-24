package cadastrouser.api.MapperConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cadastrouser.api.Mapper.UsuarioMapper;
import cadastrouser.api.Mapper.UsuarioMapperImpl;

@Configuration
public class MapperConfig {
    
    @Bean 
    public UsuarioMapper usuarioMapper(){
        return new UsuarioMapperImpl();
    }
}
