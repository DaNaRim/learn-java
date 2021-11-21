package newJdks;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class java08 {
    public static void main(String[] args) {
        //Stream
        Stream.of("hello", "great")
                .map(s -> s + " world")
                .forEach(System.out::println);

        //Optional
        Optional.of(new Random().nextInt(10))
                .filter(i -> i % 2 == 0)
                .map(i -> "number is even: " + i)
                .ifPresent(System.out::println);
    }
}
