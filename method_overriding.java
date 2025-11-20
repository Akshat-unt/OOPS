// Write a program to show the concept of method overriding in Java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Animal myAnimal = new Animal(); 
        Animal myDog = new Dog(); 

        myAnimal.sound();
        myDog.sound();
    }
}
