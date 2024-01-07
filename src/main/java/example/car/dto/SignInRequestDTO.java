package example.car.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sign in request")
public class SignInRequestDTO {

    @Schema(description = "username", example = "Jon")
    @Size(min = 1, max = 10, message = "username length must be from 1 to 10 chars")
    @NotBlank(message = "username can not be empty")
    private String username;

    @Schema(description = "password", example = "my_secret")
    @Size(min = 1, max = 10, message = "password length must be from from 1 to 10 chars")
    @NotBlank(message = "password can not be empty")
    private String password;
}
