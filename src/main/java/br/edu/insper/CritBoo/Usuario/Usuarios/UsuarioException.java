package br.edu.insper.CritBoo.Usuario.Usuarios;

import org.springframework.http.HttpStatus;

public class UsuarioException extends RuntimeException {
    private final HttpStatus status;
    public UsuarioException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
