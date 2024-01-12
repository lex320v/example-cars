package example.car.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class JwtService {
//    @Value("${jwt.secret}")
    private final String jwtSecret = "secret";

    private final Algorithm algorithm = Algorithm.HMAC256(jwtSecret);

    public String generateAccessToken(String username, String role) {
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(120).toInstant());

        return JWT.create()
                .withClaim("username", username)
                .withClaim("role", role)
                .withExpiresAt(expirationDate)
                .sign(algorithm);
    }

    public String generateRefreshToken(String username) {
        Date expirationDate = Date.from(ZonedDateTime.now().plusDays(30).toInstant());

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(expirationDate)
                .sign(algorithm);
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(algorithm).build().verify(token);

            return true;
        } catch (Exception e) {
            log.warn(e.getMessage());
        }


        return false;
    }

    public Map<String, Claim> getClaims(String token) {
        return JWT.require(algorithm).build().verify(token).getClaims();
    }
}
