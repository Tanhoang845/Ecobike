package entity.bike;


import calculator.PriceCalculator;
import calculator.StandardEBikePriceCalculator;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 19:15
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public abstract class Bike {
    protected String id;
    protected String name;
    protected String licensePlate;
    protected String status;

    protected PriceCalculator calculator;
    protected int depositPrice;

    public Bike(String id, String name, String licensePlate, String status) {
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
        this.status = status;
    }

    public PriceCalculator getCalculator() {
        return calculator;
    }

    public void setCalculator(PriceCalculator calculator) {
        this.calculator = calculator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(int depositPrice) {
        this.depositPrice = depositPrice;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Bike{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
