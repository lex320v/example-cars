package example.car.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@AllArgsConstructor
@Schema(description = "Jwt auth response")
public class JwtResponseDTO {
    private final String type = "Bearer";

    @Schema(description = "access token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
    private String accessToken;

    @Schema(description = "refresh token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
    private String refreshToken;
}
