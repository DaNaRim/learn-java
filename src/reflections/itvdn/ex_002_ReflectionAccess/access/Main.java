package reflections.itvdn.ex_002_ReflectionAccess.access;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        try {
            Class<?> cl = Dog.class;
            Dog dog = new Dog();

            Field field = cl.getDeclaredField("age");
            field.setAccessible(true);

            System.out.println("Private field value: " + field.getInt(dog));
            field.setInt(dog, 10);
            System.out.println("New private field value: " + field.getInt(dog));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static final class Dog {

        private int age = 3;
    }
}
