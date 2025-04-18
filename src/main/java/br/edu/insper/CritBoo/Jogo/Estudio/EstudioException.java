package br.edu.insper.CritBoo.Jogo.Estudio;

import org.springframework.http.HttpStatus;

public class EstudioException extends RuntimeException {
    private final HttpStatus status;
    public EstudioException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
