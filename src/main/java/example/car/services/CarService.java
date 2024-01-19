package example.car.services;

import example.car.dto.car.CarDto;
import example.car.dto.car.CarMapper;
import example.car.dto.car.ResponseSavedCarDto;
import example.car.models.Car;
import example.car.models.User;
import example.car.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public ResponseSavedCarDto getCarById(Long id) throws BadRequestException {
        var car = carRepository.findById(id);
        if (car.isEmpty()) {
            throw new BadRequestException("car with id: " + id + " does not exist");
        }

        return CarMapper.INSTANCE.carToResponseCreatedCarDto(car.get());
    }

    public List<ResponseSavedCarDto> getCars() {
        var cars = carRepository.findAll();

        return  cars.stream().map(CarMapper.INSTANCE::carToResponseCreatedCarDto).collect(Collectors.toList());
    }

    public ResponseSavedCarDto createCar(CarDto carDTO, User currentUser) {
        Car car = Car.builder()
                .manufacturer(carDTO.manufacturer)
                .user(currentUser)
                .build();

        var savedCar = carRepository.save(car);

        return CarMapper.INSTANCE.carToResponseCreatedCarDto(savedCar);
    }
}
