package entity.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 21:53
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class Parking {
    private String id;
    private String name;
    private String address;
    private int totalHost;

    private List<Place> places = new ArrayList<>();

    public Parking(String id, String name, String address, int totalHost, float area) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.totalHost = totalHost;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private float area;

    public boolean checkEmptyHost() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalHost() {
        return totalHost;
    }

    public void setTotalHost(int totalHost) {
        this.totalHost = totalHost;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", totalHost=" + totalHost +
                ", area=" + area +
                '}';
    }

}
