package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OnlyPriceRequest {


    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price should not be less than 0")
    @Max(value = 33, message = "Price should not be greater than 33")
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
