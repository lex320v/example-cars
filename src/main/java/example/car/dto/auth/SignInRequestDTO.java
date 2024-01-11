package example.car.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sign in request")
public class SignInRequestDTO {

    @Schema(description = "username", example = "Jon")
    @Size(min = 1, max = 20)
    @NotBlank
    private String username;

    @Schema(description = "password", example = "my_secret")
    @Size(min = 1, max = 20)
    @NotBlank
    private String password;
}
