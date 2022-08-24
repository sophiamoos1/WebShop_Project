package com.example.demo.Filter;

import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class JwtTokenUtil {
    private static final Logger log = LogManager.getLogger(JwtTokenUtil.class);
    private static final long EXPIRE_DURATION = 2 * 60 * 60 * 1000L; // 2 hours

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    public String generateAccessToken(Authentication authentication) {
        return Jwts.builder()
                .setSubject("JWT access token")
                .setIssuer("Gauss")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            log.error("JWT expired");
        } catch (IllegalArgumentException ex) {
            log.error("Token is null, empty or only whitespace");
        } catch (MalformedJwtException ex) {
            log.error("JWT is invalid");
        } catch (UnsupportedJwtException ex) {
            log.error("JWT is not supported");
        } catch (SignatureException ex) {
            log.error("Signature validation failed");
        }

        return false;
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
