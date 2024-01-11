package example.car.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sign up request")
public class SignUpRequestDTO {
    @Schema(description = "username", example = "jon")
    @Size(min = 1, max = 50)
    @NotBlank
    private String username;

    @Schema(description = "email", example = "jondoe@gmail.com")
    @Size(min = 1, max = 50)
    @NotBlank
    @Email
    private String email;

    @Schema(description = "password", example = "my_secret")
    @Size(min = 1, max = 50)
    @NotBlank
    private String password;
}
