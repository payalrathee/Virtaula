package com.virtaula.utilities;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwtKey}")
    private String secret;

    @Value(("${jwtExpiry}"))
    private long jwtExpiry;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {

            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parse(token);

            return true;

        } catch(MalformedJwtException e) {
            LOGGER.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Couldn't validate JWT token: {}", e.getMessage());
        }

        return false;

    }

    public String generateJwtToken(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();

        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiry))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getSignKey() {
        byte[] byteKeys = Decoders.BASE64.decode(secret);

        return Keys.hmacShaKeyFor(byteKeys);
    }
}
