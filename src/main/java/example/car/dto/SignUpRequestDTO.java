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
    @Size(min = 1, max = 50, message = "username length must be from 1 to 50 chars")
    @NotBlank(message = "username can not be empty")
    private String username;

    @Schema(description = "email", example = "jondoe@gmail.com")
    @Size(min = 1, max = 50, message = "email length must be from 1 to 50 chars")
    @NotBlank(message = "email can not be empty")
    @Email(message = "email must have pattern user@example.com")
    private String email;

    @Schema(description = "password", example = "my_secret")
    @Size(min = 1, max = 50, message = "password length must be from from 1 to 50 chars")
    @NotBlank(message = "password can not be empty")
    private String password;
}
