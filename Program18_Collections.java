// Program 18: Write a program to implement following collections a) ArrayList b) Vector
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;

public class Program18_Collections {
    public static void main(String[] args) {
        System.out.println("=== ArrayList Demo ===\n");
        
        // ArrayList implementation
        ArrayList<String> arrayList = new ArrayList<>();
        
        // Adding elements
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add("Date");
        arrayList.add("Elderberry");
        
        System.out.println("ArrayList elements:");
        for (String fruit : arrayList) {
            System.out.println("  - " + fruit);
        }
        
        System.out.println("\nArrayList size: " + arrayList.size());
        System.out.println("Element at index 2: " + arrayList.get(2));
        
        // Removing element
        arrayList.remove("Cherry");
        System.out.println("\nAfter removing 'Cherry':");
        for (String fruit : arrayList) {
            System.out.println("  - " + fruit);
        }
        
        System.out.println("\n=== Vector Demo ===\n");
        
        // Vector implementation
        Vector<Integer> vector = new Vector<>();
        
        // Adding elements
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);
        vector.add(50);
        
        System.out.println("Vector elements:");
        Iterator<Integer> it = vector.iterator();
        while (it.hasNext()) {
            System.out.println("  - " + it.next());
        }
        
        System.out.println("\nVector size: " + vector.size());
        System.out.println("Vector capacity: " + vector.capacity());
        System.out.println("Element at index 1: " + vector.get(1));
        
        // Removing element
        vector.remove(2);
        System.out.println("\nAfter removing element at index 2:");
        for (Integer num : vector) {
            System.out.println("  - " + num);
        }
        
        // Adding more elements to show capacity increase
        System.out.println("\nAdding more elements to Vector:");
        for (int i = 60; i <= 70; i += 10) {
            vector.add(i);
        }
        System.out.println("Vector size: " + vector.size());
        System.out.println("Vector capacity: " + vector.capacity());
    }
}

