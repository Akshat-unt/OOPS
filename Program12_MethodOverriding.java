// Program 12: Write a program to show the concept of method overriding in Java
class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting...");
    }
    
    public void stop() {
        System.out.println("Vehicle is stopping...");
    }
    
    public void displayInfo() {
        System.out.println("This is a vehicle.");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car engine is starting...");
    }
    
    @Override
    public void stop() {
        System.out.println("Car is applying brakes and stopping...");
    }
    
    @Override
    public void displayInfo() {
        System.out.println("This is a car.");
    }
}

class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike engine is starting...");
    }
    
    @Override
    public void stop() {
        System.out.println("Bike is stopping...");
    }
    
    @Override
    public void displayInfo() {
        System.out.println("This is a bike.");
    }
}

public class Program12_MethodOverriding {
    public static void main(String[] args) {
        System.out.println("Demonstrating Method Overriding\n");
        
        Vehicle vehicle = new Vehicle();
        System.out.println("Vehicle:");
        vehicle.displayInfo();
        vehicle.start();
        vehicle.stop();
        
        System.out.println("\nCar:");
        Car car = new Car();
        car.displayInfo();
        car.start();
        car.stop();
        
        System.out.println("\nBike:");
        Bike bike = new Bike();
        bike.displayInfo();
        bike.start();
        bike.stop();
        
        // Runtime polymorphism
        System.out.println("\nRuntime Polymorphism:");
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        
        v1.displayInfo();
        v1.start();
        
        v2.displayInfo();
        v2.start();
    }
}

