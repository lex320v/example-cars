package example.car.dto.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCarDTO {
    @Size(min = 1, max = 20)
    @NotBlank
    private String manufacturer;
}
