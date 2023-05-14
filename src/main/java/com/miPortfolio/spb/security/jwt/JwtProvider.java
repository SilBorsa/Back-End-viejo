package com.miPortfolio.spb.security.jwt;

//esta clase es la que genera el token

import com.miPortfolio.spb.security.entity.UsuarioPpal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication){
        UsuarioPpal usuarioPpal = (UsuarioPpal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPpal.getUsername())
                             .setIssuedAt(new Date())
                             .setExpiration(new Date(new Date().getTime()+expiration*1000))
                             .signWith(SignatureAlgorithm.HS512, secret)
                             .compact();
     }
    
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try{
            //Jwts.parser().setSigningKey(secret).parse(token);
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e){
            logger.error("Token mal armado");
        } catch (UnsupportedJwtException e){
            logger.error("Token incompatible");
        } catch (ExpiredJwtException e){
            logger.error("Token expirado");
        } catch (IllegalArgumentException e){
            logger.error("Token vacio");
        } catch (SignatureException e){
            logger.error("Firma invalida");
        }
        return false;
    }
}
