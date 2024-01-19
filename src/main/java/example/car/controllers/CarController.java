package example.car.controllers;

import example.car.dto.car.CarDto;
import example.car.dto.car.ResponseSavedCarDto;
import example.car.models.Car;
import example.car.models.User;
import example.car.services.CarService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Car Controller")
@SecurityRequirement(name = "JWT")
@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @GetMapping("{id}")
    private ResponseSavedCarDto getCarById(@PathVariable Long id) throws BadRequestException {
        return carService.getCarById(id);
    }

    @GetMapping
    private List<ResponseSavedCarDto> getCars() {
        return carService.getCars();
    }
    @PostMapping
    private ResponseSavedCarDto createCar(@RequestBody @Valid CarDto request, @AuthenticationPrincipal User user) {
     return carService.createCar(request, user);
    }
    @PutMapping
    private Car updateCar() {
        return null;
    }
}
