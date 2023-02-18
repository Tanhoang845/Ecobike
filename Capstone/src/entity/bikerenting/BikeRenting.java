package entity.bikerenting;

import entity.bike.Bike;
import entity.user.User;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 22:58
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class BikeRenting {
    private String id;
    private long startTime;
    private Bike bike;
    private User user;

    private boolean isReturned;

    public BikeRenting(long startTime, Bike bike, User user) {
        this.startTime = startTime;
        this.bike = bike;
        this.user = user;
    }

    public BikeRenting(String id, long startTime, Bike bike, User user) {
        this.id = id;
        this.startTime = startTime;
        this.bike = bike;
        this.user = user;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
