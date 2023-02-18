package entity.bike;

import calculator.TwinBikePriceCalculator;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 19:23
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class TwinBike extends Bike {
    public TwinBike(String id, String name, String licensePlate, String status) {
        super(id, name, licensePlate, status);
        setCalculator(new TwinBikePriceCalculator());
        setDepositPrice(300);
    }

    @Override
    public String getType() {
        return "xe dap doi";
    }

    @Override
    public String toString() {
        return "TwinBike{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
