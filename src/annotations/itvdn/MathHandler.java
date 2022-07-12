package annotations.itvdn;

public class MathHandler {


    @MathAnno(num1 = 1, num2 = 4)
    public void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}
