package newJdks.java15;

public sealed interface Fruit permits Apple, Pear {
    String getName();

    /*
    A sealed class imposes three important constraints on its permitted subclasses:

       1. All permitted subclasses must belong to the same module as the sealed class.
       2. Every permitted subclass must explicitly extend the sealed class.
       3. Every permitted subclass must define a modifier: final, sealed, or non-sealed.
     */
}
