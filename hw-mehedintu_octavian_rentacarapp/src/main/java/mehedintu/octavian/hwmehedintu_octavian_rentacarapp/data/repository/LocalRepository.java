package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.repository;

import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.CarTypeAndNrContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocalRepository {
    public static List<CarTypeAndNrContainer> printNrOfCarsOfEachType() {
        List<CarTypeAndNrContainer> someTypesAndNr= new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_schema", "root", "toor")) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT type,\n" +
                    "COUNT(id)\n" +
                    " FROM car_schema.cars\n" +
                    " GROUP BY type");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
                someTypesAndNr.add(new CarTypeAndNrContainer(resultSet.getString(1),resultSet.getInt(2)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return someTypesAndNr;
    }
}
