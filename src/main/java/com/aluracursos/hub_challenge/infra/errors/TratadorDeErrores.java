package com.aluracursos.hub_challenge.infra.errors;

import com.aluracursos.hub_challenge.infra.exceptions.TopicoNoEncontradoException;
import com.aluracursos.hub_challenge.infra.exceptions.ValidacionException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErrores {
    @ExceptionHandler(TopicoNoEncontradoException.class)
    public ResponseEntity<DatosErrorException> handleTopicoNoEncontradoException(TopicoNoEncontradoException ex) {
        // Retorna un mensaje y un código de estado 404 Not Found
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DatosErrorException(
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.value()
                ));
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<DatosErrorException> handleValidacionException(ValidacionException ex) {
        // Retorna un mensaje y un código de estado 404 Not Found
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DatosErrorException(
                        ex.getMessage(),
                        HttpStatus.BAD_REQUEST.value()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DatosErrorValidacion> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> "El campo '" + error.getField() + "' " + error.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DatosErrorValidacion("Error de validación", HttpStatus.BAD_REQUEST.value(), errores));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DatosErrorException> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String mensajeError = "Valor no válido para el campo. Asegúrese de que el valor del campo 'estado' sea uno de los siguientes: ABIERTO, CERRADO.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DatosErrorException(mensajeError, HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<DatosErrorException> handleTokenExpiredException(TokenExpiredException ex) {
        String mensajeError = "El token ha expirado. Por favor, inicie sesión nuevamente para obtener un nuevo token.";
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new DatosErrorException(mensajeError, HttpStatus.UNAUTHORIZED.value()));
    }
}
