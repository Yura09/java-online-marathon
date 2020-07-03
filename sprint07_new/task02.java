import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String reviewer();

    String date() default "today";
}
@SuppressWarnings("unchecked")
class Util {
    
    public static void review(String className) {
        Class myClass;
        try {
            myClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
            return;
        }
        Review annotation = (Review) myClass.getAnnotation(Review.class);
        if (annotation == null) {
            System.out.println("Class " + className + " isn't marked as Reviewed");
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        if (annotation.date().equals("today")) {
            date = simpleDateFormat.format(new Date());
        } else {
            Date d = null;
            try {
                d = simpleDateFormat.parse(annotation.date());
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
            date = simpleDateFormat.format(d);
        }


        System.out.println("Class " + className + " was reviewed " + date + " by " + annotation.reviewer()+'.');

    }

}
