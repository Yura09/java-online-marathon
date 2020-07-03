import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite {
    String[] value() default "";
}
@SuppressWarnings("unchecked")
class TestSuitHandler {
   
    public static void run(Class clazz)  {
        TestSuite annotation = (TestSuite) clazz.getAnnotation(TestSuite.class);
        String clazzName = clazz.getSimpleName();
        Method[] methods = clazz.getDeclaredMethods();
        if (annotation == null) {
            System.out.println("Class " + clazzName + " isn't annotated");
            return;
        }
      
        for(String s:annotation.value()){
            Method method= null;
            try {
                method = clazz.getMethod(s);

            } catch (NoSuchMethodException e) {
                System.out.println("Method with name " + s + " doesn't exists or not public in class " + clazzName);
                continue;
            }
            String methodName=method.getName();
            if (!Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                if(!Modifier.isPublic(method.getModifiers())){
                    System.out.println("Method with name " + methodName + " doesn't exists or not public in class " + clazzName);
                }else {
                    System.out.println("\t -- Method " + clazzName + "." + methodName + " started --");
                    try {
                        method.invoke(clazz.getDeclaredConstructor().newInstance());
                    } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\t -- Method " + clazzName + "." + methodName + " finished --");
                }
            }

        }
    }
}
