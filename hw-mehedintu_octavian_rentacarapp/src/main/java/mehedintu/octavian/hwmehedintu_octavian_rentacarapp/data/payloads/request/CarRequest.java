package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.payloads.request;

import mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models.Type;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

public class CarRequest {

        @NotBlank(message = "Brand cannot be blank")
        @NotNull(message = "Brand cannot be null")
        @Size(min=2, max=200)
        private String brand;

        @NotBlank(message = "Model cannot be blank")
        @NotNull(message = "Model cannot be null")
        @Size(min=2, max=200)
        private String model;


        @NotNull(message = "Price cannot be null")
        @Min(value = 0, message = "Price should not be less than 0")
        @Max(value = 33, message = "Price should not be greater than 33")
        private double price;


        @NotNull(message = "Type cannot be null")
        @Enumerated(EnumType.STRING)
        private Type type;

        @NotBlank(message = "Color cannot be blank")
        @NotNull(message = "Color cannot be null")
        @Size(min=2, max=50)
        private String color;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price>18&&(type==Type.ECONOMY)){
        this.price =18;
        }else if (price>30&&(type==Type.STANDARD))
        this.price =30;
        else
        this.price = price;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
