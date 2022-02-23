package other;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorExample {

    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");

        Iterator<String> it = animals.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Difference between for-each loop and iterator

        Iterator<String> it2 = animals.iterator();
        while (it2.hasNext()) {
            it2.next();
            it2.remove(); // valid here
        }

        for (String str : animals) {
            animals.remove(str); // throws Exception
        }
    }
}
