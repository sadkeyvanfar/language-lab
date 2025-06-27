package ir.java.misc;

public class EnumStrategy {
    // Example of an enum with a strategy pattern
    public enum Strategy {
        ADDITION {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        },
        SUBTRACTION {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        },
        MULTIPLICATION {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };

        public abstract int apply(int a, int b);
    }

    public static void main(String[] args) {
        // Using the enum strategies
        System.out.println("Addition: " + Strategy.ADDITION.apply(5, 3));
        System.out.println("Subtraction: " + Strategy.SUBTRACTION.apply(5, 3));
        System.out.println("Multiplication: " + Strategy.MULTIPLICATION.apply(5, 3));
    }

}
