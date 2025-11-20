// Program 17: Write a Program to implement simple Thread by extending Thread class and implementing runnable interface
// Thread by extending Thread class
class MyThread extends Thread {
    private String threadName;
    
    public MyThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        System.out.println("Thread (extending Thread): " + threadName + " is running...");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " (Thread): " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " finished.");
    }
}

// Thread by implementing Runnable interface
class MyRunnableThread implements Runnable {
    private String threadName;
    
    public MyRunnableThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        System.out.println("Thread (implementing Runnable): " + threadName + " is running...");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " (Runnable): " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " finished.");
    }
}

public class Program17_ThreadExtend {
    public static void main(String[] args) {
        System.out.println("Main thread started.\n");
        
        // Creating thread by extending Thread class
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        
        // Creating thread by implementing Runnable interface
        MyRunnableThread runnable1 = new MyRunnableThread("Runnable-1");
        MyRunnableThread runnable2 = new MyRunnableThread("Runnable-2");
        
        Thread thread3 = new Thread(runnable1);
        Thread thread4 = new Thread(runnable2);
        
        System.out.println("Starting threads...\n");
        
        // Starting threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        try {
            // Wait for all threads to complete
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.println("\nMain thread finished.");
    }
}

