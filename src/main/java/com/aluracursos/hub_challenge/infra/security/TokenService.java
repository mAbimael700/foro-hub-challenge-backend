package com.aluracursos.hub_challenge.infra.security;

import com.aluracursos.hub_challenge.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    private final String issuer = "hub-challenge";

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(usuario.getCorreoElectronico())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("El token no puede ser nulo o vacío");
        }


        Algorithm algorithm = Algorithm.HMAC256(apiSecret);
        DecodedJWT verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build()
                .verify(token);


        String subject = verifier.getSubject();
        if (subject == null) {
            throw new RuntimeException("El 'subject' es nulo en el token");
        }
        return subject;


    }


    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
