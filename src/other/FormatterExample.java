package other;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static java.util.Calendar.MAY;

public class FormatterExample {

    public static void main(String[] args) {
        formatterExample1();
        formatterWithInput();
        /*
        %d - int
        %s - string
        %f - double
        %t, %T	date/time
         */
        formatterExample2();
        formatterWithCalendar();
        formatterExample3();
    }

    private static void formatterExample1() {

        try (Formatter f = new Formatter("E:\\SoloLearn.txt")) {

            f.format("%s %s %s", "1", "John", "Smith\r\n");
            f.format("%s %s %s", "2", "Amy", "Brown");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void formatterWithInput() {
        try (Formatter f = new Formatter("E:\\SoloLearn.txt");
             Scanner sc = new Scanner(System.in)) {

            int num = sc.nextInt();
            String str = sc.next();
            double db = sc.nextDouble();

            f.format("Num: %d, Str: %s, db: %f", num, str, db);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void formatterExample2() {
        System.out.format("e = %+10.4f\n", Math.E);
        System.out.format("e = %+1.5f", Math.E);
    }

    private static void formatterWithCalendar() {
        System.out.format("Местное время: %tT", Calendar.getInstance());

        Calendar c = new GregorianCalendar(1995, MAY, 23);
        Calendar c1 = Calendar.getInstance();
        String str1 = String.format("Duke's Birthday: %1$tm %1$te %1$tY", c);
        System.out.println(str1);
        System.out.printf("%% Current date: %1$te.%1$tm.%1$tY", c1);
    }

    private static void formatterExample3() {
        int a = 1, b = 2, c = 3, d = 4;
        System.out.printf("%4$d %3$d %2$d %1$d\n", a, b, c, d);
        System.out.printf("%4$d %2$d %2$d %1$d%n", a, b, c, d);
        System.out.printf("%4$d %4$d %1$d %3$d\n", a, b, c, d);
    }
}
