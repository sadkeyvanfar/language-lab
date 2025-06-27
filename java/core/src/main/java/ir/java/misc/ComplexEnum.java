package ir.java.misc;

public class ComplexEnum {
    // Example of a complex enum in Java
    public enum Status {
        PENDING("Pending", 1),
        APPROVED("Approved", 2),
        REJECTED("Rejected", 3);

        private final String description;
        private final int code;

        Status(String description, int code) {
            this.description = description;
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public int getCode() {
            return code;
        }
    }

    public static void main(String[] args) {
        // Using the complex enum
        Status currentStatus = Status.APPROVED;
        System.out.println("Current Status: " + currentStatus.getDescription() + " (Code: " + currentStatus.getCode() + ")");
    }
}
