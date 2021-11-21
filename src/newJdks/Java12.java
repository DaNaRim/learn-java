package newJdks;

public class Java12 {
    public static void main(String[] args) {
        //Switch expressions
        //old
        var i = 3;
        String s;
        switch (i) {
            case 1:
                s = "one";
                break;
            case 2:
                s = "two";
                break;
            case 3:
                s = "three";
                break;
            default:
                s = "unknown number";
        }

        //new
        var i2 = 3;
        var x = switch (i) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            default -> "unknown number";
        };

        String day = "SATURDAY";
        boolean isTodayHoliday = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
            case "SATURDAY", "SUNDAY" -> true;
            default -> throw new IllegalArgumentException("What's a " + day);
        };

        //String Class New Methods
        String text = "Hello Baeldung!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);
    }
}
