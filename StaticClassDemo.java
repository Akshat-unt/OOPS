class OuterClass {
    int outerValue = 50;
    static int staticValue = 100;
    public void Displayabc()
    {
        System.out.println("outer value is"+ outerValue);
    }

    // Static nested class
    static class StaticNestedClass {
        void display() {
            // Can access only static members of outer class directly
            System.out.println("Static Value: " + staticValue);

            // Cannot access non-static (instance) members directly
            // System.out.println(outerValue); //  Not allowed
        }
    }
}

public class StaticClassDemo {
    public static void main(String[] args) {
        // Create object of static nested class (no need of OuterClass object)
        OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();
        nestedObj.display();
        OuterClass ob1 = new OuterClass();
        ob1.Displayabc();
       // ob1.display();
    }
}
