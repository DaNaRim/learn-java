package reflections.itvdn;

import java.util.Map;

public class SimpleReflection {

    public static void main(String[] args) throws ClassNotFoundException {
//         1. getClass()
        SimpleReflection simpleReflection = new SimpleReflection();
        Class<?> cl = simpleReflection.getClass();

        int[] arr = new int[10];
        Class<?> cl2 = arr.getClass();
        Class<?> cl3 = "world".getClass();
        Class<?> cl4 = Integer.valueOf(5).getClass();
        System.out.println(cl);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl4);

        // 2. String.class
        Class<?> cl21 = SimpleReflection.class;
        Class<?> cl22 = int[].class;

        // 3. Class.forName()
        Class<?> cl31 = Class.forName("java.lang.String");
        System.out.println(cl31);

        Class<?> cl32 = Class.forName("[I");
        Class<?> cl33 = Class.forName("[D");
        System.out.println(cl33);

        // 4.
        Class<?> cl41 = Integer.class.getSuperclass();
        System.out.println(cl41);

        Class<?> cl42 = Map.Entry.class.getEnclosingClass();
        System.out.println(cl42);
    }
}
