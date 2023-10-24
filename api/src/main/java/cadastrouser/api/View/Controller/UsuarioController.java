package cadastrouser.api.View.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cadastrouser.api.Service.UsuarioService;
import cadastrouser.api.Shared.UsuarioDTO;
import cadastrouser.api.Mapper.UsuarioMapper;
import cadastrouser.api.View.Model.UsuarioRequest;
import cadastrouser.api.View.Model.UsuarioResponse;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired 
    UsuarioService usuarioservice;

    @Autowired
    UsuarioMapper mapper;

    @GetMapping
    public List<UsuarioResponse> getAll(){
        List<UsuarioDTO> listaDto = usuarioservice.getAll();
        List<UsuarioResponse> listaResponse = new ArrayList<>();
        for (UsuarioDTO u : listaDto) {
            UsuarioResponse usuarioResponse = mapper.toResponse(u);
            listaResponse.add(usuarioResponse);
        }
        return listaResponse;
    }
    /* 
    @GetMapping("/{id}")
    public Optional<UsuarioResponse> getById(@PathVariable Long id){
        
    }
    */
    
    @PostMapping
    public UsuarioResponse createUser(@RequestBody UsuarioRequest usuarioReq){
        UsuarioDTO usuarioDto = mapper.fromRequest(usuarioReq);
        usuarioservice.create(usuarioDto);
        UsuarioResponse response = mapper.toResponse(usuarioDto);

        return response;
    }

    @GetMapping("{id}")
    public UsuarioResponse getById(@PathVariable Long id){
        Optional<UsuarioDTO> dto = usuarioservice.getById(id);
        UsuarioResponse response = mapper.toResponse(dto.get());
        return response;
    }

    @PutMapping("/{id}")
    public UsuarioResponse updateUser(@PathVariable Long id,@RequestBody UsuarioRequest request){
        UsuarioDTO dto = mapper.fromRequest(request);
        usuarioservice.update(dto, id);
        UsuarioResponse response = mapper.toResponse(dto);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        usuarioservice.delete(id);
        
    }
}
