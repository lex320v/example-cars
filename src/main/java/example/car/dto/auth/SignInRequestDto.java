package example.car.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "Sign in request")
public class SignInRequestDto {
    @Schema(description = "username", example = "Jon")
    @Size(min = 1, max = 20)
    @NotBlank
    private String username;

    @Schema(description = "password", example = "my_secret")
    @Size(min = 1, max = 20)
    @NotBlank
    private String password;
}
