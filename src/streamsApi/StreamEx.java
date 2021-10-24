package streamsApi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx {

    public static void main(String[] args) {

        List<Person> people = getPeople();

/*
        List<Person> female = new ArrayList<>();
        for (Person person : people) {

            if (person.getGender().equals("FEMALE")) {
                female.add(person);
            }
        }
        female.forEach(System.out::println);
*/

        //Filter
        List<Person> female2 = people.stream()
                .filter(person -> person.getGender().equals("FEMALE"))
                .collect(Collectors.toList());
        female2.forEach(System.out::println);


        System.out.println();

        //Sort
        List<Person> female3Sorted = people.stream()
//                .sorted(Comparator.comparing(Person::getAge))
//                .sorted(Comparator.comparing(Person::getAge).reversed())
                .sorted(Comparator.comparing(Person::getGender)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
        female3Sorted.forEach(System.out::println);


        System.out.println();

        //All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println(allMatch);


        System.out.println();

        //AnyMatch
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 100);
        System.out.println(anyMatch);


        System.out.println();

        //NoneMatch
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);


        System.out.println();

        //max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);


        System.out.println();

        //min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);


        System.out.println();

        //Group
        Map<String, List<Person>> groupingByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupingByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

        System.out.println();

        people.stream()
                .filter(person -> person.getGender().equals("FEMALE"))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .ifPresent(System.out::println);


        System.out.println();

        //average age
        people.stream()
                .mapToInt(Person::getAge)
                .average()
                .ifPresent(System.out::println);

        System.out.println();


        //find average age by gender
        people.stream()
                .collect(Collectors.groupingBy(Person::getGender))
                .forEach((gender, people1) -> {
                    System.out.print(gender + " ");
                    people1.stream().mapToInt(Person::getAge)
                            .average()
                            .ifPresent(System.out::println);
                });
    }


    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, "MALE"),
                new Person("Alina Smith", 33, "FEMALE"),
                new Person("Helen White", 57, "FEMALE"),
                new Person("Alex Boz", 14, "MALE"),
                new Person("Jamie Goa", 99, "MALE"),
                new Person("Anna Cook", 7, "FEMALE"),
                new Person("Zelda Brown", 120, "FEMALE")
        );
    }
}
