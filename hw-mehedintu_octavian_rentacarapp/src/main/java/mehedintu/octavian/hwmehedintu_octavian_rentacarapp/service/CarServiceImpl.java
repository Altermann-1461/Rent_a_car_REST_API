package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.service;

import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.CarTypeAndNrContainer;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.Cars;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.Type;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request.CarRequest;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request.OnlyPriceRequest;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.response.MessageResponse;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.repository.CarRepository;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.repository.LocalRepository;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public MessageResponse createCar(CarRequest carRequest) {
        Cars newCar = new Cars();
        newCar.setBrand(carRequest.getBrand());
        newCar.setModel(carRequest.getModel());
        newCar.setColor(carRequest.getColor());
        newCar.setPrice(carRequest.getPrice());
        newCar.setType(carRequest.getType());
        carRepository.save(newCar);
        return new MessageResponse("New Car created successfully");

    }

    @Override
    public Optional<Cars> updateCar(Integer carId, CarRequest carRequest)  throws ResourceNotFoundException {
        Optional<Cars> car = carRepository.findById(carId);
        if (car.isEmpty()){
            throw new ResourceNotFoundException("Car", "id", carId);
        }
        else
            car.get().setBrand(carRequest.getBrand());
        car.get().setModel(carRequest.getModel());
        car.get().setColor(carRequest.getColor());

        car.get().setPrice(carRequest.getPrice());
        car.get().setType(carRequest.getType());
        carRepository.save(car.get());
        return car;
    }

    @Override
    public Optional<Cars> updateCarsPrice(Integer carId, OnlyPriceRequest onlyPriceRequest) throws ResourceNotFoundException{
        Optional<Cars> car = carRepository.findById(carId);
        if (car.isEmpty()){
            throw new ResourceNotFoundException("Car", "id", carId);
        }
        else{
            if(onlyPriceRequest.getPrice()>18&&(car.get().getType()== Type.ECONOMY)){
                car.get().setPrice(18);
            }else if (onlyPriceRequest.getPrice()>30&&(car.get().getType()==Type.STANDARD))
                car.get().setPrice(30);
            else
            car.get().setPrice(onlyPriceRequest.getPrice());
            carRepository.save(car.get());}

        return car;
    }

    @Override
    public Cars getASingleCar(Integer carId) throws ResourceNotFoundException{
        return carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
    }

    @Override
    public List<Cars> getAllCars() {
        return carRepository.findAll(Sort.by("price"));
    }
    @Override
    public void deleteCar(Integer carId) throws ResourceNotFoundException {
        if (carRepository.getById(carId).getId().equals(carId)){
            carRepository.deleteById(carId);
        }
        else throw new ResourceNotFoundException("Car", "id", carId);
    }

    @Override
    public List<CarTypeAndNrContainer> getNumberOfCarTypes() {
        return LocalRepository.printNrOfCarsOfEachType();
    }
}
