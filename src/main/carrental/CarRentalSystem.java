package main.carrental;

import java.io.*;
import java.util.*;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
        loadFromFile();
    }

    public void addCar(Car car) {
        cars.add(car);
        saveToFile();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveToFile();
    }

    public void rentCar(String regNo, String licenseNumber, String rentDate, String returnDate) {
        Car car = findCarByRegNo(regNo);
        Customer customer = findCustomerByLicense(licenseNumber);
        if (Objects.nonNull(car) && Objects.nonNull(customer) && !car.isRented()) {
            car.setRented(true);
            Rental rental = new Rental(customer, car, rentDate, returnDate);
            rentals.add(rental);
            saveToFile();
        }
    }

    public Car findCarByRegNo(String regNo) {
        Optional<Car> car = cars.stream().filter(c -> regNo.equals(c.getRegNo())).findFirst();
        return car.orElse(null);
    }

    public Customer findCustomerByLicense(String license) {
        Optional<Customer> customer = customers.stream().filter(c -> license.equals(c.getLicenseNumber())).findFirst();
        return customer.orElse(null);
    }

    public void displayCars() {
        cars.forEach(System.out::println);
    }

    public void displayCustomers() {
        customers.forEach(System.out::println);
    }

    public void displayRentals() {
        rentals.forEach(System.out::println);
    }

    private void saveToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/files/car-customer-rental.dat"));
            out.writeObject(cars);
            out.writeObject(customers);
            out.writeObject(rentals);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/files/car-customer-rental.dat"));
            cars = (List<Car>) in.readObject();
            customers = (List<Customer>) in.readObject();
            rentals = (List<Rental>) in.readObject();
        } catch (FileNotFoundException e) {
            cars = new ArrayList<>();
            customers = new ArrayList<>();
            rentals = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
