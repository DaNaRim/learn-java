package reflections.itvdn.ex_003_ClassForName.featuresOfClass;

import java.lang.reflect.Member;

public class Main2 {

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c);
            printMembers(c.getFields());
            printMembers(c.getConstructors());
            printMembers(c.getMethods());
        } catch (ClassNotFoundException e) {
            System.out.println("Неизвестный класс:" + args[0]);
        }
    }

    private static void printMembers(Member[] mems) {
        for (Member mem : mems) {
            if (mem.getDeclaringClass() == Object.class) {
                continue;
            }
            String decl = mem.toString();
            System.out.print("   ");
            System.out.println(decl);
        }
    }
}

