package multithreading.itvdn.lesson5.functions;

import java.util.Random;
import java.util.function.*;

public class FunctionExample {

    public static void main(String[] args) {
        Consumer<String> helloConsumer = string -> System.out.println("hello " + string);
        helloConsumer.accept("ITVDN");

        Function<Integer, String> integerStringFunction = integer -> "Value:" + integer;
        System.out.println(integerStringFunction.apply(5));

        Supplier<String> supplier = () -> {
            Random random = new Random();
            return "Random value:" + random.nextInt(100);
        };
        System.out.println(supplier.get());

        BiFunction<Consumer<String>, Supplier<String>, Boolean> biFunction = (consumer, supplier1) -> {
            String supplierValue = supplier1.get();
            consumer.accept(supplierValue);
            return true;
        };
        System.out.println(biFunction.apply(helloConsumer, supplier));

        BiConsumer<Consumer<String>, Supplier<String>> biConsumer = (consumer, supplier1) -> {
            String supplierValue = supplier1.get();
            consumer.accept(supplierValue);
        };
        biConsumer.accept(helloConsumer, supplier);
    }

}
