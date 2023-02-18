package entity.parking;

import entity.bike.Bike;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 21:51
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class Place {
    private String parkingID;
    private int hostNumber;
    private String bikeID;


    public Place(String parkingID, int hostNumber, String bikeID) {
        this.parkingID = parkingID;
        this.hostNumber = hostNumber;
        this.bikeID = bikeID;
    }

    public String getParkingID() {
        return parkingID;
    }

    public void setParkingID(String parkingID) {
        this.parkingID = parkingID;
    }

    public int getHostNumber() {
        return hostNumber;
    }

    public void setHostNumber(int hostNumber) {
        this.hostNumber = hostNumber;
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }
}
