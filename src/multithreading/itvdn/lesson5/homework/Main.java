package multithreading.itvdn.lesson5.homework;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Function;

public class Main {

    /*
    Deferred d = new Deferred();
    d.then(res -> {System.out.println("2 " + res); return "a";});
    d.then(res -> {System.out.println("1 " + res); return "b";});
    d.then(res -> {System.out.println("3 " + res); return "c";});
    d.then(res -> {System.out.println("yay " + res); return "yay";});

    // at this point, nothing is printed to console (yet)

    d.resolve("hello");
    // output of usage example
    // 2 hello
    // 1 a
    // 3 b
    // yay c
    // ========================
    */

    public static void main(String[] args) {
        Deferred d = new Deferred();
        d.then(res -> {
            System.out.println("2 " + res);
            return "a";
        });
        d.then(res -> {
            System.out.println("1 " + res);
            return "b";
        });
        d.then(res -> {
            System.out.println("3 " + res);
            return "c";
        });
        d.then(res -> {
            System.out.println("yay " + res);
            return "yay";
        });

        d.resolve("hello");
    }

    static class Deferred {

        private final Queue<Function<String, String>> actions = new ArrayDeque<>();

        public void then(Function<String, String> action) {
            actions.add(action);
        }

        public void resolve(String text) {
            Iterator<Function<String, String>> iterator = actions.iterator();

            String res = text;
            while (iterator.hasNext()) {
                res = iterator.next().apply(res);
            }
        }

    }
}
