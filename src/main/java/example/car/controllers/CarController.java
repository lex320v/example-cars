package example.car.controllers;

import example.car.dto.car.CarDTO;
import example.car.exceptions.NotFoundException;
import example.car.models.Car;
import example.car.services.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @GetMapping("{id}")
    private Car getCarById(@PathVariable int id) {
        System.out.println(id);
        if (id != 1) throw new NotFoundException("Пользователь не найден");

        return carService.getCars().stream().findFirst().orElse(null);
    }

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
