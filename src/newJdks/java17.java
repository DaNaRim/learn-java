package newJdks;

public class java17 {
    public static void main(String[] args) {
        //Pattern Matching for Switch
        TestClass t = new Inh();
        String a = switch (t) {
            case Inh i -> 0 + i.toString();
            case Inh2 i && (i.field == 0) -> "Yes";
            default -> "Def";
        };
        System.out.println(a);
    }

    static class TestClass {
        int field = 0;
    }

    static class Inh extends TestClass {

    }

    static class Inh2 extends TestClass {

    }
}
