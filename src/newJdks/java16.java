package newJdks;

import jdk.incubator.vector.IntVector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java16 {
    public static void main(String[] args) {
        //Add Stream.toList Method
        List<String> integersAsString = Arrays.asList("1", "2", "3");
        //old
        List<Integer> ints = integersAsString.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //new
        List<Integer> intsEquivalent = integersAsString.stream()
                .map(Integer::parseInt)
                .toList();


        //Vector API Incubator
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};
        int[] c = new int[a.length];
        //old
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b[i];
        }

        //new
        var vectorA = IntVector.fromArray(IntVector.SPECIES_128, a, 0);
        var vectorB = IntVector.fromArray(IntVector.SPECIES_128, b, 0);
        var vectorC = vectorA.mul(vectorB);
        vectorC.intoArray(c, 0);
    }
}
