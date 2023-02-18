package entity.bike;

import calculator.StandardEBikePriceCalculator;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 19:22
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class StandardEBike extends Bike {
    private int battery;

    public StandardEBike(String id, String name, String licensePlate, String status, int battery) {
        super(id, name, licensePlate, status);
        this.battery = battery;
        setCalculator(new StandardEBikePriceCalculator());
        setDepositPrice(200);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public String getType() {
        return "xe dap dien thuong";
    }

    @Override
    public String toString() {
        return "StandardEBike{" +
                "battery=" + battery +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
