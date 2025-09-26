class Parent {
    final void display() {
        System.out.println("Final method: cannot be overridden");
    }
}

class Child extends Parent {
    // Error: cannot override final method
    // void display() { }
    
    void show() {
        System.out.println("Child method");
    }
}

class Main {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display(); // calls Parent class method
        obj.show();
    }
}
