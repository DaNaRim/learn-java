package streamsApi.Exercises;

import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {

    public static void main(String[] args) {
        //Exercise 1 — Obtain a list of products belongs to category “vegetables” with price > 20

        List<Product> vegetables = products.stream()
                .filter(product -> product.getCategory().equals("vegetables"))
                .filter(product -> product.getPrice() > 20)
                .collect(Collectors.toList());

        vegetables.forEach(System.out::println);
    }

    static List<Product> products = List.of(
            new Product(1L, "potato", "vegetables", 30.00),
            new Product(2L, "carrot", "vegetables", 15.50),
            new Product(3L, "cabbage", "vegetables", 20.00),
            new Product(4L, "table", "furniture", 300.00),
            new Product(5L, "pen", "stationery", 30.00),
            new Product(6L, "ruler", "stationery", 125.00),
            new Product(7L, "pencil", "stationery", 25.00)
    );
}
