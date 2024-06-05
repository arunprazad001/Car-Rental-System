package main.carrental;

import java.io.Serializable;

public class Car implements Serializable {
    private String modelName;
    private String regNo;
    private boolean isRented;

    public Car(String modelName, String regNo) {
        this.modelName = modelName;
        this.regNo = regNo;
        this.isRented = false;
    }

    public String getModelName() {
        return modelName;
    }
    public String getRegNo() {
        return regNo;
    }
    public boolean isRented() {
        return isRented;
    }
    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "main.carrental.Car{" +
                "modelName='" + modelName + '\'' +
                ", regNo='" + regNo + '\'' +
                ", isRented=" + isRented +
                '}';
    }
}
