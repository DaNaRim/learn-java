package newJdks;

import java.util.HashSet;
import java.util.List;

public class java10 {
    public static void main(String[] args) {
        //Keyword var
        var f = 4;
        f++;
        System.out.println(f);

        var s = "Some text";
        s += "ff";
        System.out.println(s);

        var x = new HashSet<String>();
        x.add("apple");

        //copyOf() for Collection
        List<Integer> someList = List.of(1, 2, 3, 4);
        List<Integer> copyList = List.copyOf(someList);
        copyList.add(4);
    }
}
