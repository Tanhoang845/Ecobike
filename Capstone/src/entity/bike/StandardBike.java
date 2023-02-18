package entity.bike;

import calculator.StandardBikePriceCalculator;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 19:21
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class StandardBike extends Bike {
    public StandardBike(String id, String name, String licensePlate, String status) {
        super(id, name, licensePlate, status);
        setCalculator(new StandardBikePriceCalculator());
        setDepositPrice(100);
    }

    @Override
    public String getType() {
        return "Xe dap don thuong";
    }

    @Override
    public String toString() {
        return "StandardBike{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
