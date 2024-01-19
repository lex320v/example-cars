package example.car.dto.car;

import lombok.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
public class ResponseSavedCarDto {
    private Long id;
    private String manufacturer;
    private UserDto user;
}
