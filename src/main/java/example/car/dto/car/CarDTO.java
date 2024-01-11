package example.car.dto.car;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema
public class CarDTO {
    @Size(min = 4, max = 20)
    @NotBlank
    private String manufacturer;
}
