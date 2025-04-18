package br.edu.insper.CritBoo.common;

import br.edu.insper.CritBoo.Jogo.Avaliacao.AvaliacaoException;
import br.edu.insper.CritBoo.Jogo.Categoria.CategoriaException;
import br.edu.insper.CritBoo.Jogo.Estudio.EstudioException;
import br.edu.insper.CritBoo.Jogo.Jogos.JogoException;
import br.edu.insper.CritBoo.Post.Noticia.NoticiaException;
import br.edu.insper.CritBoo.Post.Posts.PostException;
import br.edu.insper.CritBoo.Usuario.Usuarios.UsuarioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdviceHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDTO> responseStatusException(ResponseStatusException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getReason(),
                exeption.getStatusCode().value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(exeption.getStatusCode()).body(errorDTO);
    }

    @ExceptionHandler(AvaliacaoException.class)
    public ResponseEntity<ErrorDTO> avaliacaoException(AvaliacaoException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getMessage(),
                exeption.getStatus().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exeption.getStatus().value()).body(errorDTO);
    }

    @ExceptionHandler(CategoriaException.class)
    public ResponseEntity<ErrorDTO> categoriaException(CategoriaException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getMessage(),
                exeption.getStatus().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exeption.getStatus().value()).body(errorDTO);
    }

    @ExceptionHandler(JogoException.class)
    public ResponseEntity<ErrorDTO> jogoException(JogoException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getMessage(),
                exeption.getStatus().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exeption.getStatus().value()).body(errorDTO);
    }

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<ErrorDTO> usuarioException(UsuarioException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getMessage(),
                exeption.getStatus().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exeption.getStatus().value()).body(errorDTO);
    }

    @ExceptionHandler(EstudioException.class)
    public ResponseEntity<ErrorDTO> estudioException(EstudioException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getMessage(),
                exeption.getStatus().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exeption.getStatus().value()).body(errorDTO);
    }
    @ExceptionHandler(NoticiaException.class)
    public ResponseEntity<ErrorDTO> noticiaException(NoticiaException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getMessage(),
                exeption.getStatus().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exeption.getStatus().value()).body(errorDTO);
    }
    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorDTO> postException(PostException exeption) {
        ErrorDTO errorDTO = new ErrorDTO(
                exeption.getMessage(),
                exeption.getStatus().value(),
                LocalDateTime.now());

        return ResponseEntity.status(exeption.getStatus().value()).body(errorDTO);
    }
}
