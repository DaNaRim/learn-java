package annotations.itvdn;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MathAnno {

    int num1() default 0;

    int num2() default 0;
}
