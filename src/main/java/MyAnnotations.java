import java.lang.reflect.Method;

public class MyAnnotations {
    @Test(a = 2, b = 5)
    public static void myMethod() {
        MyAnnotations myAnnotations = new MyAnnotations();
        try {
            Class cl = myAnnotations.getClass();
            Method m = cl.getMethod("myMethod");
            Test ann = m.getAnnotation(Test.class);
            System.out.println(ann.a() + " " + ann.b());
        } catch (NoSuchMethodException exc) {
            System.err.println("404 Not found.");
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
