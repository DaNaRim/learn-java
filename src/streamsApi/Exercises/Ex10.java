package streamsApi.Exercises;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Ex10 {

    public static void main(String[] args) {
        //Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count)
        //for all products of category “stationery”

        DoubleSummaryStatistics statistics = products.stream()
                .filter(product -> product.getCategory().equals("stationery"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();

        System.out.println(statistics);

//        System.out.printf("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f%n",
//                statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum());
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
