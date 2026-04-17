import java.util.Scanner;
public class QuantityMeasurementApp {

    // Step 1: Extended Enum
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),          // 1 inch = 1/12 feet
        YARD(3.0),                 // 1 yard = 3 feet
        CENTIMETER(0.0328084);     // 1 cm = 0.0328084 feet

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // Step 2: SAME QuantityLength class (no change)
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

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }
    }

    // Step 3: Main method (Demo)
    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q4 = new QuantityLength(36.0, LengthUnit.INCH);

        QuantityLength q5 = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength q6 = new QuantityLength(0.393701, LengthUnit.INCH);

        System.out.println("1 yard vs 3 feet → " + q1.equals(q2)); // true
        System.out.println("1 yard vs 36 inches → " + q3.equals(q4)); // true
        System.out.println("1 cm vs 0.393701 inch → " + q5.equals(q6)); // true

        System.out.println("2 yards vs 6 feet → " +
                new QuantityLength(2.0, LengthUnit.YARD)
                        .equals(new QuantityLength(6.0, LengthUnit.FEET))); // true

        System.out.println("1 cm vs 1 feet → " +
                new QuantityLength(1.0, LengthUnit.CENTIMETER)
                        .equals(new QuantityLength(1.0, LengthUnit.FEET))); // false
    }
}
