package br.edu.insper.CritBoo.Post.Noticia;

import org.springframework.http.HttpStatus;

public class NoticiaException extends RuntimeException {
    private final HttpStatus status;
    public NoticiaException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
