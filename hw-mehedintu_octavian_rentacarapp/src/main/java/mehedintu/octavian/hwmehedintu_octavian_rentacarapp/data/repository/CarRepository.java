package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.repository;


import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.CarTypeAndNrContainer;
import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Cars, Integer> {
    @Query(value="SELECT type,\n" +
            "COUNT(id)\n" +
            " FROM Cars\n" +
            " GROUP BY type", nativeQuery = true)
    List<CarTypeAndNrContainer> listOfAllCarTypesAndTheNumber();
}
