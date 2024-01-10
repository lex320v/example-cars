package example.car.controllers;

import example.car.dto.car.CreateCarDTO;
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
    private Car createCar(@RequestBody @Valid CreateCarDTO request) {
     return carService.createCar(new Car());
    }
}
