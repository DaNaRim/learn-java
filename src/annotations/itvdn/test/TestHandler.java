package annotations.itvdn.test;

import java.lang.reflect.Method;

public class TestHandler {

    public static boolean test(Class<?>... ls) {
        try {
            for (Class<?> cl : ls) {
                Method[] methods = cl.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(TestAnno.class)) {
                        Boolean b = (Boolean) method.invoke(null, new Object[]{});
                        if (!b) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
