package newJdks;

import java.util.Arrays;
import java.util.List;

public class java09 {

    //JShell
    /*
    $ <JDK>/bin/jshell
    jshell> System.out.println("hello world")
    hello world
     */

    public static void main(String[] args) {
        //Factory methods for immutable collections
        //old
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        //new
        List<Integer> list2 = List.of(1, 2, 3, 4);
    }
}
