package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.service;


import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.CarTypeAndNrContainer;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.Cars;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request.CarRequest;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request.OnlyPriceRequest;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CarService {
    MessageResponse createCar(CarRequest carRequest);
    Optional<Cars> updateCar(Integer carId, CarRequest carRequest);
    Optional<Cars> updateCarsPrice(Integer carId, OnlyPriceRequest onlyPriceRequest);
    void deleteCar(Integer carId);
    Cars getASingleCar(Integer carId);
    List<Cars> getAllCars();
    List<CarTypeAndNrContainer> getNumberOfCarTypes();
}
