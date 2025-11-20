// Program 10: Write a program in Java to show the inheritance in java and use of super keyword
class Animal {
    String name;
    int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal constructor called");
    }
    
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
}

class Dog extends Animal {
    String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age); // Using super keyword to call parent constructor
        this.breed = breed;
        System.out.println("Dog constructor called");
    }
    
    @Override
    public void display() {
        super.display(); // Using super keyword to call parent method
        System.out.println("Breed: " + breed);
    }
    
    public void bark() {
        System.out.println(name + " is barking.");
    }
}

public class Program10_Inheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        System.out.println("\nDog Details:");
        dog.display();
        System.out.println();
        dog.eat();
        dog.bark();
    }
}

