package annotations.itvdn.ex_001_Annotations.methods;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        try {
            AnotherDog dog = new AnotherDog();
            Class<?> cl = dog.getClass();
            Annotation[] classAnnotations = cl.getAnnotations();

            System.out.println(cl.getName() + "\nAnnotations:");
            for (Annotation annotation : classAnnotations) {
                System.out.println("\t" + annotation);
            }
            Method[] classMethods = cl.getMethods();
            System.out.println("Method annotations:");
            for (Method method : classMethods) {
                Annotation[] methodAnnotations = method.getAnnotations();
                if (methodAnnotations.length > 0) {
                    System.out.println("\t" + method.getName() + "():");
                }
                for (Annotation annotation : methodAnnotations) {
                    System.out.println("\t" + annotation);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
