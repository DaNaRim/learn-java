package annotations.itvdn.ex_001_Annotations.javaDoc;

/**
 * @author Yevhenii Tykhonov
 */
public class Person {

    /**
     * person's name
     */
    private String name;

    /**
     * This is a constructor to initialize person's object.
     *
     * @param name an initial person name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * get person's name
     *
     * @return person's name
     */
    public String getName() {
        return name;
    }

    /**
     * To set a name of a person
     *
     * @param name a new person name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * show person's name
     *
     * @return person's name
     */
    public String show() {
        return "show: " + name;
    }

    /**
     * return a message from a person object
     *
     * @return I am a person
     */
    public String talk() {
        return "I'm a person";
    }
}

class Student extends Person {

    /**
     * student's age
     */
    private int age;

    /**
     * @param name student's name
     * @param age  student's age
     */
    public Student(String name, int age) {
        super(name);
        this.age = age;
    }
}
