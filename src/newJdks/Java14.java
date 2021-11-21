package newJdks;

public class Java14 {
    public static void main(String[] args) {
        //Date classes: record
        Employee employee = new Employee("Bill", 13, "TestDep");
        System.out.println(employee.age());

        //instanceof without type conversion
        //old
        Object obj = "hello";
        if (obj instanceof String) {
            System.out.println("String length: " + ((String)obj).length());
        }

        //new
        Object obj2 = "hello";
        if (obj2 instanceof String mystr) {
            System.out.println("String length: " + mystr.length());
        }
    }
}

record Employee(String name, int age, String department) {
}
