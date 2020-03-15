import java.math.BigDecimal;
import java.math.BigInteger;

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
        BigInteger bigInteger1 = BigInteger.valueOf(3);

        bigInteger = bigInteger.add(bigInteger1);

        bigInteger = bigInteger.multiply(bigInteger1);

        BigDecimal bigDecimal = BigDecimal.valueOf(5555); //для роботи з дуже великими дробовими числами
    }
}