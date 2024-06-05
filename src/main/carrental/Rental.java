package main.carrental;


import java.io.Serializable;

public class Rental implements Serializable {
    private Customer customer;
    private Car car;
    private String rentedDate;
    private String returnDate;

    public Rental(Customer customer, Car car, String rentedDate, String returnDate) {
        this.customer = customer;
        this.car = car;
        this.rentedDate = rentedDate;
        this.returnDate = returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public String getRentedDate() {
        return rentedDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "customer=" + customer +
                ", car=" + car +
                ", rentedDate='" + rentedDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
