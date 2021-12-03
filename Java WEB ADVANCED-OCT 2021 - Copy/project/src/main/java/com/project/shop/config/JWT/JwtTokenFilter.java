package com.project.shop.config.JWT;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.identityArea.service.IdentityService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.aspectj.util.LangUtil.isEmpty;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final IdentityService identityService;

    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, IdentityService identityService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.identityService = identityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        try {
//        // Get authorization header and validate
            final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (isEmpty(header) || !header.startsWith("Bearer ")) {
                chain.doFilter(request, response);
                return;
            }

//        // Get jwt token and validate
            final String token = header.split(" ")[1].trim();
            // Get user identity and set it on the spring security context
            UserEntity userDetails = identityService
                    .findByUsername(jwtTokenUtil.getUsernameFromToken(token)).get();
//                .orElse(null);
            if (!jwtTokenUtil.validateToken(token, userDetails)) {
                chain.doFilter(request, response);
                return;
            }

            UsernamePasswordAuthenticationToken
                    authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            request.setAttribute("exception", e);
        }

        chain.doFilter(request, response);

    }

}
