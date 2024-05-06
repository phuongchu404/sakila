package com.film.sakila.jwt;

import com.film.sakila.security.UserDetailsImpl;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class JwtUtils {
    @Value("${app.security.jwtSecret}")
    private String jwtSecret;

    @Value("${app.security.jwtExpiration}")
    private String jwtExpiration;

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime()+ jwtExpiration);
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, key())
                .compact();
    }

    private Key key(){
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return Keys.hmacShaKeyFor(Encoders.BASE64.encode(jwtSecret.getBytes()).getBytes());
    }
    public String getUserNameFromJwtToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(key()).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateJwtToken(String token){
        try {
            Jwts.parser().setSigningKey(key()).parse(token);
            return true;
        }catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        }catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}",e.getMessage());
        }catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}",e.getMessage());
        }catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}",e.getMessage());
        }
        return false;
    }
}
