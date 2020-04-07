import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class MyUtils {
    public static class Student {
        private int id;
        private String name;
        // Constructor, metthods, Code
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
             if(student.name==null)return true;
            return id == student.id &&
                    name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
        
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        // Code
         Set<Student> set = new HashSet<>(list1);
        set.retainAll(list2);

        return set;
    }
}
