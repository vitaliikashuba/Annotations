import java.lang.annotation.*;
import java.lang.reflect.*;

// создание аннотации
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    int a();
    int b();
}

