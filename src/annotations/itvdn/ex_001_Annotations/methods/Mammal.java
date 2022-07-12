package annotations.itvdn.ex_001_Annotations.methods;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Mammal {

    /**
     * @return sound of a mammal
     */
    String sound() default "Meow";

    /**
     * @return color of mammal
     */
    Color[] color() default Color.BLACK;
}
