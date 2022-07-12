package annotations.itvdn.ex_001_Annotations.documentation;

import java.lang.annotation.Documented;

/**
 * @author Nazar Horshevikov
 */
public class Main {

    @ClassPreamble(
            author = "Nazar",
            date = "24/06/2018",
            currentRevision = 5,
            lastModified = "24/06/2018",
            lastModifiedBy = "Nazar Horshevikov",
            reviewers = {"Nazar", "Alex", "Bob"}
    )
    public static void main(String[] args) {
    }

    @Documented
    @interface ClassPreamble {

        String author();

        String date();

        int currentRevision() default 1;

        String lastModified() default "N/A";

        String lastModifiedBy() default "N/A";

        String[] reviewers();
    }
}

