package newJdks;

public class Java13 {
    public static void main(String[] args) {
        //Multi-line Strings
        var s = """
                {
                    "recipe": "watermelon smoothie",
                    "duration": "10 mins",
                    "items": ["watermelon", "lemon", "parsley"]
                }""";

        String str = """
                "Some string" and "some new string"
                """;
        System.out.println(s);

        //Switch Expressions
        var me = 4;
        var operation = "squareMe";
        var result = switch (operation) {
            case "doubleMe" -> {
                System.out.println("Text");
                yield me * 2;
            }
            case "squareMe" -> {
                System.out.println("Text");
                yield me * me;
            }
            default -> me;
        };
    }
}
