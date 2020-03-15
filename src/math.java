import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class math {
    public static void main(String[] args) {

        double numDouble = Math.pow(0, 0); // піднесення до степеня (число, степінь)
        System.out.println(numDouble);

        int numInt = (int) Math.pow(11, 2);
        System.out.println(numInt);

        numDouble = Math.sqrt(3); // добування квадратного кореня
        System.out.println(numDouble);

        numDouble = Math.cbrt(-27); // добування кубічного кореня
        System.out.println(numDouble);

        numInt = Math.abs(-3); // модуль
        System.out.println(numInt);

        numDouble = Math.ceil(9.1); // округлення до більшого 1 = 1
        System.out.println(numDouble);

        numDouble = Math.floor(4.9); // округлення до меньшого або взяття цілої частини
        System.out.println(numDouble);

        numDouble = Math.rint(0.5); // округлення до найближчого, 0.5 = 0
        System.out.println(numDouble);

        long numLong = Math.round(0.5); // округлення до найближчого, 0.5 = 1
        System.out.println(numLong);

        numInt = Math.max(5, 9); // отримання більшого з двох чисел
        System.out.println(numInt);

        numInt = Math.min(44, 23); // отримання меншого з двох чисел
        System.out.println(numInt);

        numDouble = Math.random(); //рандомне число є [0, 1}
        System.out.println(numDouble); //16 цифр після коми

        BigInteger bigInteger = BigInteger.valueOf(42); //для роботи з дуже великими цілими числами
        BigInteger bigInteger1 = new BigInteger("333333333333333333333333333333333333333333333333333333333333333");

        BigDecimal bigDecimal = BigDecimal.valueOf(5555); //для роботи з дуже великими дробовими числами
        BigDecimal bigDecimal2 = new BigDecimal("422.44432134333336666666666666666666666666666666666666666666663");

        BigInteger big3 = new BigInteger("3");

        bigInteger = bigInteger.add(big3); //число не зміниться, треба створювати новий об'єкт

        BigInteger Integer1 = bigInteger.add(big3); //додавання
        BigInteger Integer2 = bigInteger.subtract(big3); //віднімання
        BigInteger Integer3 = bigInteger.multiply(big3); //множення
        BigInteger Integer4 = bigInteger.divide(big3); //ділення

        long bigIntegerToLong = bigInteger.longValue(); // переведення в long
        //ще є doubleValue(), intValue(), floatValue()

        //округлення

        //setScale(кількість знаків після коми, правило округлення);

        BigDecimal bigDecimal0 = new BigDecimal("111.55599");

        BigDecimal decimal1 = bigDecimal0.setScale(3, RoundingMode.CEILING); //округлення в більшу сторону
        //111.5555555555 -> 111.556

        BigDecimal decimal3 = bigDecimal0.setScale(3, RoundingMode.FLOOR); //округлення в меншу сторону
        //111.55599 -> 111.555

        BigDecimal decimal2 = bigDecimal0.setScale(3, RoundingMode.DOWN); //відкидання розряду
        //111.55544 -> 111.555

        BigDecimal decimal6 = bigDecimal0.setScale(3, RoundingMode.UP); //округлення в більшу сторону
        //111.5551 -> 111.556

        BigDecimal decimal4 = bigDecimal0.setScale(1, RoundingMode.HALF_UP);
            //округлення в більшу сторону якщо число після коми >= 0.5
        //0.55 -> 0.6
        //0.54 -> 0.5

        BigDecimal decimal5 = bigDecimal0.setScale(1, RoundingMode.HALF_DOWN);
        //округлення в більшу сторону якщо число після коми > 0.5
        //0.55 -> 0.5
        //0.56 -> 0.6
    }
}