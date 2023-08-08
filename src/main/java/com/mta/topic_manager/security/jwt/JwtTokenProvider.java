package com.mta.topic_manager.security.jwt;

import com.mta.topic_manager.security.userscurity.UserDetailsimpl;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${ra.jwt.secret}")
    private String JWT_SECRET;
    @Value("${ra.jwt.expiration}")
    private int JWT_EXPIRATION;
    // tao jwt tu thong tin cua user
    public String[] generateToken(Authentication authentication){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now=new Date();
        Date dateExpired= new Date(now.getTime()+JWT_EXPIRATION);
        UserDetailsimpl userDetailsimpl= (UserDetailsimpl)authentication.getPrincipal();
        //tao chuoi jwt tu email
        return new String[]{Jwts.builder().setSubject(userDetailsimpl.getEmail())
                .setIssuedAt(now)//thoi diem taoj jwt
                .setExpiration(dateExpired)//thoi gian het han
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact()
        ,sdf.format(dateExpired)}; //expired time;
    }
    //Lay thong tin user tu jwt
    public String getEmailFromJwt(String token){
        Claims claims= Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        //tra ra email
        return claims.getSubject();
    }
    //validate thong tin cau chuoi jwt
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token);
            return true;
        }catch(SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
            return false;
    }

}
