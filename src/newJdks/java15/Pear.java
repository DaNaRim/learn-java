package newJdks.java15;

//permitted subclass may also be declared sealed. However, if we declare it non-sealed, then it is open for extension
public non-sealed class Pear implements Fruit {
    @Override
    public String getName() {
        return "Pear";
    }
}
