import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CamelCase {

}

class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "[a-z]+[a-zA-Z0-9]*$";

    public static boolean checkAndPrint(Class clazz) {
        boolean flag = true;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(CamelCase.class)) {
                if (!method.getName().matches(CAMELCASE_PATTERN)) {
                    flag = false;
                    System.out.println("method " + clazz.getSimpleName() + "." + method.getName() + " doesn't satisfy camelCase naming convention");
                }
            }
        }
        return flag;
    }
}


class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    public static void _main(String args[]) {
    }

    @CamelCase
    public void Example() {
    }
}

public class Class1 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void InCorrect() {
    }

    @CamelCase
    public void JustMethod() {
    }
}

public class Class2 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void oneMoreCorrect() {
    }
}

