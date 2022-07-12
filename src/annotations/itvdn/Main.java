package annotations.itvdn;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        MathHandler mathHandler = new MathHandler();

        Class<?> cl = MathHandler.class;

        try {
            Method m = cl.getDeclaredMethod("add", int.class, int.class);
            MathAnno mathAnno = m.getAnnotation(MathAnno.class);

            mathHandler.add(mathAnno.num1(), mathAnno.num2());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
