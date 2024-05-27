package com.film.jwt;

import com.film.exception.TokenException;
import com.film.jwt.security.UserDetailsImpl;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class JwtUtils {
    //private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${app.security.jwtSecret}")
    private String jwtSecret;

    @Value("${app.security.jwtExpiration}")
    private int jwtExpiration;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

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
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
//        redisTemplate.opsForValue().set(token, token, jwtExpiration, TimeUnit.SECONDS);
        log.error("token: {}", token);
        return token;
    }

    //refresh token
    public String getUserNameFromJwtToken(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    private Key key(){
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
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

    public void refreshToken(String token) {
        redisTemplate.expire(token,jwtExpiration, TimeUnit.SECONDS);
    }

    public String getToken(String token) {
        String tokenInRedis = redisTemplate.opsForValue().get(token);
        if(StringUtils.isEmpty(tokenInRedis)) {
            throw  new TokenException(token, "Not found");
        }
        return tokenInRedis;
    }
}
