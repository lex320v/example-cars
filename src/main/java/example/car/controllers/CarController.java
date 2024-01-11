package example.car.controllers;

import example.car.dto.car.CarDTO;
import example.car.models.Car;
import example.car.services.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @GetMapping
    private List<Car> getCars() {
        return carService.getCars();
    }
    @PostMapping
    private Car createCar(@RequestBody @Valid CarDTO request) {
        System.out.println(carService);


     return carService.createCar(request);
    }
    @PutMapping
    private Car updateCar(@RequestBody @Valid CarDTO request) {
        return carService.getCars().stream().findFirst().orElse(null);
    }
}
