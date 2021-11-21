package newJdks;

import java.util.List;
import java.util.stream.Collectors;

public class Java11 {
    public static void main(String[] args) {
        //Single Source File Launch
        //"java" instead of "javac" then "java"
        System.out.println("hello world");

        //new String methods: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
