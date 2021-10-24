package streamsApi.Exercises;

import java.util.Comparator;
import java.util.List;

public class Ex05 {

    public static void main(String[] args) {
        //Exercise 5 — Get the cheapest products of “vegetables” category

        Product vegetableWithMinPrice = products.stream()
                .filter(product -> product.getCategory().equals("vegetables"))
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);

        System.out.println(vegetableWithMinPrice);
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
