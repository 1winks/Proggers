package org.proggers.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class Authenticator {
    private static final SignatureAlgorithm ALGO = SignatureAlgorithm.HS256;
    private static final Key KEY = Keys.secretKeyFor(ALGO);
    private static final long EXPIRE = 10_000_000;
    public String genToken (String user) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + EXPIRE))
                .signWith(KEY, ALGO)
                .compact();
    }
    public String valToken (String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}
