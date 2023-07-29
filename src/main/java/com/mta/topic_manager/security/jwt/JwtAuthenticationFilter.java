package com.mta.topic_manager.security.jwt;

import com.mta.topic_manager.security.userscurity.UserDetailsServiceimpl;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Slf4j
public class JwtAuthenticationFilter  extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserDetailsServiceimpl userDetailsServiceimpl;


    //lay jwt tu header request
    private String getJwtFromRequest(HttpServletRequest request){
        String bearerToken=request.getHeader(HttpHeaders.AUTHORIZATION);
        if( bearerToken!=null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;

    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
        try{
            //lay jwt tu request
            String jwt = getJwtFromRequest(request);
            if(jwt!=null&& jwtTokenProvider.validateToken(jwt)){
                //lay email tu chuoi jwt
                String email=jwtTokenProvider.getEmailFromJwt(jwt);
                //lay thong tin user tu email
                UserDetails userDetails =userDetailsServiceimpl.loadUserByUsername(email);
                if(userDetails!=null){
                    //set thong tin cho    security context
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    //dinh token len web
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }catch (Exception e) {
            log.error("can not set user authentication: {}",e.getMessage());
        }
        filterChain.doFilter(request,response);
    }

//    @Override
//    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws IOException {
//
//    }
}
