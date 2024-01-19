package example.car.dto.car;

import example.car.models.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    ResponseSavedCarDto carToResponseCreatedCarDto(Car car);
}
