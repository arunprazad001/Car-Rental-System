package main.carrental;

import java.util.Scanner;

public class CarRentalSystemApplication {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem=new CarRentalSystem();
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to proceed? select yes/no!");
        String decision=sc.next();
        if(decision.equals("yes")){
            while(true) {
                System.out.println("WELCOME TO NO:1 RENTALS!");
                System.out.println("1. Add Car!");
                System.out.println("2. Add Customer!");
                System.out.println("3. Rent Car!");
                System.out.println("4. Display Cars!");
                System.out.println("5. Display Customers!");
                System.out.println("6. Display Rentals!");
                System.out.println("7. Exit!");
                int option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Enter car details!");
                        System.out.println("Enter model name!");
                        String model = sc.next();
                        System.out.println("Enter Reg No!");
                        String regNo = sc.next();
                        carRentalSystem.addCar(new Car(model, regNo));
                        break;
                    case 2:
                        System.out.println("Enter customer details!");
                        System.out.println("Enter name!");
                        String name = sc.next();
                        System.out.println("Enter license number!");
                        String licenseNumber = sc.next();
                        carRentalSystem.addCustomer(new Customer(name, licenseNumber));
                        break;
                    case 3:
                        System.out.println("Enter details for renting car!");
                        System.out.println("Enter regNo!");
                        String carRegNo = sc.next();
                        System.out.println("Enter License Number!");
                        String license = sc.next();
                        System.out.println("Enter rental date!");
                        String rentDate = sc.next();
                        System.out.println("Enter return date!");
                        String returnDate = sc.next();
                        carRentalSystem.rentCar(carRegNo, license, rentDate, returnDate);
                        break;
                    case 4:
                        carRentalSystem.displayCars();
                        break;
                    case 5:
                        carRentalSystem.displayCustomers();
                        break;
                    case 6:
                        carRentalSystem.displayRentals();
                        break;
                    case 7:
                        System.out.println("Thank you for using our service!");
                        System.exit(0);
                        break;
                }
            }
        }else{
            System.out.println("Thank you!");
            System.exit(0);
        }
    }
}