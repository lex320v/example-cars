package example.car.services;

import example.car.dto.car.CarDto;
import example.car.dto.car.CarMapper;
import example.car.dto.car.ResponseCreatedCarDto;
import example.car.models.Car;
import example.car.models.User;
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

    public ResponseCreatedCarDto createCar(CarDto carDTO, User currentUser) {
        Car car = Car.builder()
                .manufacturer(carDTO.manufacturer)
                .user(currentUser)
                .build();

        Car savedCar = carRepository.save(car);

        return CarMapper.INSTANCE.carToResponseCreatedCarDto(savedCar);
    }
}
