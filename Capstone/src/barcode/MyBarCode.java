package barcode;

/**
 * @Project: Capstone
 * @Author: luongthitam
 * @Date: 2/5/2023
 * @Time: 23:47
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class MyBarCode implements BarCodeAPI {
    public String toBikeCode(String barCode) {
        return "b" + String.format("%05d", 99999 - Integer.parseInt(barCode.substring(1)));
    }

    @Override
    public String toBarCode(String bikeCode) {
        return "#" + String.format("%05d", 99999 - Integer.parseInt(bikeCode.substring(1)));
    }

    public static void main(String[] args) {
        System.out.println(new MyBarCode().toBikeCode("#99998"));
        System.out.println(new MyBarCode().toBarCode("b00001"));
    }
}

