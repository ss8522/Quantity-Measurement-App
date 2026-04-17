import java.util.Scanner;
public class QuantityMeasurementApp {

    // Step 1: Enum for Units
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0); // 1 inch = 1/12 feet

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // Step 2: Generic Quantity Class
    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        // Convert to base unit (feet)
        private double toFeet() {
            return unit.toFeet(value);
        }

        // equals() with conversion
        @Override
        public boolean equals(Object obj) {

            // Same reference
            if (this == obj) return true;

            // Null or type check
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            // Compare after converting both to feet
            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }
    }

    // Main method (Demo)
    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.INCH);

        System.out.println("1 ft vs 12 inch → " + q1.equals(q2)); // true
        System.out.println("1 inch vs 1 inch → " + q3.equals(q4)); // true
        System.out.println("1 ft vs 2 ft → " +
                new QuantityLength(1.0, LengthUnit.FEET)
                        .equals(new QuantityLength(2.0, LengthUnit.FEET))); // false
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

