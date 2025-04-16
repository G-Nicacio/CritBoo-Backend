package br.edu.insper.CritBoo.Jogo;

import org.springframework.http.HttpStatus;

public class JogoException extends RuntimeException {
    private final HttpStatus status;
    public JogoException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
