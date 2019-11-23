import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SaveTo(path = "c:\\folder\\textfile.txt")
public class TestContainer {
    private String text = "text for save";

    @Save
    public void save(String path) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(path))) {
            fw.write(text);
            System.out.println("File succsesfully saved ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 class Main {
    public static void main(String[] args) {
        TestContainer exmp = new TestContainer();
        Class<?> cls = exmp.getClass();
        SaveTo saveAnn = cls.getAnnotation(SaveTo.class);
        Method[] methods = cls.getDeclaredMethods();
        for (Method met : methods) {
            if (met.isAnnotationPresent(Save.class)) {
                try {
                    met.invoke(exmp, saveAnn.path()); // выполняем метод
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}