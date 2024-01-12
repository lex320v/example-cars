package example.car.services;

import example.car.dto.car.CarDTO;
import example.car.models.Car;
import example.car.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car createCar(CarDTO carDTO) {
        Car car = Car.builder()
                .manufacturer(carDTO.getManufacturer())
                .build();

        return carRepository.save(car);
    }
}
