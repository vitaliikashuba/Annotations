import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String path() default "c:\\folder\\textfile.txt";
}
