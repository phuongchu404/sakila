package com.film.sakila.jwt;

import com.film.sakila.jwt.security.UserDetailsImpl;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class JwtUtils {
    //private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${app.security.jwtSecret}")
    private String jwtSecret;

    @Value("${app.security.jwtExpiration}")
    private int jwtExpiration;

//    public String generateJwtToken(Authentication authentication){
//        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime()+ jwtExpiration);
//        return Jwts.builder()
//                .setSubject(userPrincipal.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS256, key())
//                .compact();
//    }

    // refresh token
    public String generateJwtToken(UserDetailsImpl principal){
        return generateTokenFromUsername(principal.getUsername());
    }

    // refresh token
    public String generateTokenFromUsername(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    //refresh token
    public String getUserNameFromJwtToken(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    private Key key(){
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        byte[] test = Encoders.BASE64.encode(jwtSecret.getBytes(StandardCharsets.UTF_8)).getBytes();
        return Keys.hmacShaKeyFor(Encoders.BASE64.encode(jwtSecret.getBytes(StandardCharsets.UTF_8)).getBytes());
    }
//    public String getUserNameFromJwtToken(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(key()).parseClaimsJws(token).getBody();
//        return claims.getSubject();
//    }

//    public boolean validateJwtToken(String token){
//        try {
//            Jwts.parser().setSigningKey(key()).parse(token);
//            return true;
//        } catch (SignatureException e) {
//            log.error("Invalid JWT signature: {}", e.getMessage());
//        }catch (MalformedJwtException e) {
//            log.error("Invalid JWT token: {}", e.getMessage());
//        }catch (ExpiredJwtException e) {
//            log.error("JWT token is expired: {}",e.getMessage());
//        }catch (UnsupportedJwtException e) {
//            log.error("JWT token is unsupported: {}",e.getMessage());
//        }catch (IllegalArgumentException e) {
//            log.error("JWT claims string is empty: {}",e.getMessage());
//        }
//        return false;
//    }

    // refresh token
    public boolean validateJwtToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parse(token);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
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
