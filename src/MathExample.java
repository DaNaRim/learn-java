import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class MathExample {

    public static void main(String[] args) {

        System.out.println(Math.pow(0, 0)); //exaltation to a degree (number, degree)
        System.out.println(Math.pow(11, 2));

        System.out.println(Math.sqrt(3)); //extracting the square root

        System.out.println(Math.cbrt(-27)); //extraction of a cubic root

        System.out.println(Math.abs(-3)); //module


        System.out.println(Math.ceil(9.1)); //rounding up 1 = 1

        System.out.println(Math.floor(4.9)); //rounding to the smallest or taking the whole part

        System.out.println(Math.rint(0.5)); //rounding to the nearest, 0.5 = 0

        System.out.println(Math.round(0.5)); //rounding to the nearest, 0.5 = 1

        System.out.println(Math.random()); //random number є [0, 1} 16 digits after the comma


        BigInteger bigInteger = BigInteger.valueOf(42); //to work with very large integers
        BigInteger bigInteger1 = new BigInteger("333333333333333333333333333333333333333333333333333333333333333");

        BigDecimal bigDecimal = BigDecimal.valueOf(5555); //for working with very large fractional numbers
        BigDecimal bigDecimal2 = new BigDecimal("422.44432134333336666666666666666666666666666666666666666666663");

        BigInteger big3 = new BigInteger("3");
        bigInteger = bigInteger.add(big3); //the number will not change, you need to create a new object

        BigInteger Integer1 = bigInteger.add(big3); // +
        BigInteger Integer2 = bigInteger.subtract(big3); // -
        BigInteger Integer3 = bigInteger.multiply(big3); // *
        BigInteger Integer4 = bigInteger.divide(big3); //  /

        long bigIntegerToLong = bigInteger.longValue(); // conversion to long
        //doubleValue(), intValue(), floatValue()


        //setScale(number of decimal places, rounding rule);

        BigDecimal bigDecimal0 = new BigDecimal("111.55599");

        BigDecimal decimal1 = bigDecimal0.setScale(3, RoundingMode.CEILING); //rounding up
        //111.5555555555 -> 111.556

        BigDecimal decimal3 = bigDecimal0.setScale(3, RoundingMode.FLOOR); //rounding down
        //111.55599 -> 111.555

        BigDecimal decimal2 = bigDecimal0.setScale(3, RoundingMode.DOWN); //cut the discharge
        //111.55544 -> 111.555

        BigDecimal decimal6 = bigDecimal0.setScale(3, RoundingMode.UP); //rounding up
        //111.5551 -> 111.556

        BigDecimal decimal4 = bigDecimal0.setScale(1, RoundingMode.HALF_UP);
        //rounding to the greater side if the number after the comma >= 0.5
        //0.55 -> 0.6
        //0.54 -> 0.5

        BigDecimal decimal5 = bigDecimal0.setScale(1, RoundingMode.HALF_DOWN);
        //rounding to the greater side if the number after the comma is > 0.5
        //0.55 -> 0.5
        //0.56 -> 0.6
    }
}