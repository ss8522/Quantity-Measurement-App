import java.util.Scanner;
public class QuantityMeasurementApp {
    static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Getter (optional)
        public double getValue() {
            return value;
        }

        // Override equals() method
        @Override
        public boolean equals(Object obj) {

            // Step 1: Same reference check (Reflexive)
            if (this == obj) {
                return true;
            }

            // Step 2: Null check
            if (obj == null) {
                return false;
            }

            // Step 3: Type check
            if (getClass() != obj.getClass()) {
                return false;
            }

            // Step 4: Cast safely
            Feet other = (Feet) obj;

            // Step 5: Compare values using Double.compare()
            return Double.compare(this.value, other.value) == 0;
        }
    }
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }
    public static boolean compareFeet(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    // Static method for Inches equality
    public static boolean compareInches(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }

    public static void main(String[] args) {


        boolean feetResult = compareFeet(1.0, 1.0);
        System.out.println("1.0 ft vs 1.0 ft → " + feetResult);

        // Inches comparison
        boolean inchResult = compareInches(1.0, 1.0);
        System.out.println("1.0 inch vs 1.0 inch → " + inchResult);

        // Different values
        System.out.println("1.0 ft vs 2.0 ft → " + compareFeet(1.0, 2.0));
        System.out.println("1.0 inch vs 2.0 inch → " + compareInches(1.0, 2.0));
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        System.out.println("1.0 ft vs 1.0 ft → " + f1.equals(f2)); // true
        System.out.println("1.0 ft vs 2.0 ft → " + f1.equals(f3)); // false
        System.out.println("1.0 ft vs null → " + f1.equals(null)); // false
        System.out.println("Same reference → " + f1.equals(f1));   // true
    }
}

