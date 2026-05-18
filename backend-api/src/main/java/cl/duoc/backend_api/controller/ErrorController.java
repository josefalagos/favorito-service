package cl.duoc.backend_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> noEncontrado(IllegalArgumentException ex) {
        return Map.of("error", "No se encontró el producto favorito solicitado.");
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> errorGeneral(Exception ex) {
        return Map.of("error", "Error interno del servidor: " + ex.getMessage());
    }
}