package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.web;

import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.CarTypeAndNrContainer;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.Cars;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request.CarRequest;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request.OnlyPriceRequest;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.response.MessageResponse;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
   public ResponseEntity<List<Cars>> getAllCars () {

        List<Cars> cars = carService.getAllCars();
       return new ResponseEntity<>(cars, HttpStatus.OK);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Cars> getCarById (@PathVariable("id") Integer id) {
        Cars car = carService.getASingleCar(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    @GetMapping("/findNrOfCarsOfEachType")
    public ResponseEntity<List<CarTypeAndNrContainer>> getNrOfTypes(){
        List<CarTypeAndNrContainer> typesAndNr= carService.getNumberOfCarTypes();
        return new ResponseEntity<>(typesAndNr,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addCar(@Valid @RequestBody  CarRequest car) {
        MessageResponse newCar = carService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public Optional<Cars> updateCar(@PathVariable Integer id,@Valid @RequestBody  CarRequest car) {
        return carService.updateCar(id, car);
    }

     @PutMapping("/updatePrice/{id}")
      public Optional<Cars> updateCar(@PathVariable Integer id,@Valid @RequestBody  OnlyPriceRequest onlyPriceRequest) {
      double price= onlyPriceRequest.getPrice();
      return carService.updateCarsPrice(id, onlyPriceRequest);


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
