package cadastrouser.api.View.Model.Error;

import lombok.Data;

@Data
public class ErrorMessage {
    private String titulo;
    private Integer status;
    private String mensagem;
    
    public ErrorMessage(String titulo, Integer status, String mensagem) {
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensagem;
    }

}
