package br.edu.insper.CritBoo.Jogo;

import org.springframework.http.HttpStatus;

public class CategoriaException extends RuntimeException {
    private final HttpStatus status;
    public CategoriaException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
