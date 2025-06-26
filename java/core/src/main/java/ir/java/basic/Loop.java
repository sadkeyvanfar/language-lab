package ir.java.basic;

public class Loop {
    public static void main(String[] args) {
        // Example of a for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("For Loop Iteration: " + i);
        }

        // Example of a while loop
        int j = 0;
        while (j < 5) {
            System.out.println("While Loop Iteration: " + j);
            j++;
        }

        // Example of a do-while loop
        int k = 0;
        do {
            System.out.println("Do-While Loop Iteration: " + k);
            k++;
        } while (k < 5);

        // Example of a for-each loop
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (String fruit : fruits) {
            System.out.println("For-Each Loop Fruit: " + fruit);
        }
    }
}
