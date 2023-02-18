package barcode;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 19:28
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface BarCodeAPI {
    /**
     *
     * @param barCode {@link java.lang.String}
     * @return bikeId {@link java.lang.String}
     */
    String toBikeCode(String barCode);
    String toBarCode(String bikeCode);
}
