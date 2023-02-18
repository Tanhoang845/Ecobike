package calculator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 23:28
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class RentalFeeCalculator {
    private PriceCalculator calculator;

    public RentalFeeCalculator() {
    }

    public RentalFeeCalculator(PriceCalculator calculator) {
        this.calculator = calculator;
    }

    public PriceCalculator getCalculator() {
        return calculator;
    }

    public void setCalculator(PriceCalculator calculator) {
        this.calculator = calculator;
    }

    public int calculateRentalFee(int minute) {
        return calculator.calculate(minute);
    }

    public int calculateUseTime(long startTime) {
        long diff = new Date().getTime() - startTime;
        return (int) (diff / (60 * 1000));
    }

    public static void main(String[] args) throws ParseException {
        RentalFeeCalculator calculator = new RentalFeeCalculator();
        calculator.setCalculator(new StandardBikePriceCalculator());
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        Date date = sdf.parse("23/02/05 23:00:00");
        System.out.println(calculator.calculateUseTime(date.getTime()));
        System.out.println(date instanceof Date);
    }
}
