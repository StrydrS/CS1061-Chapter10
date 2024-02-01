import java.util.ArrayList;

public class chapter10_4 {
    public static void main(String[] args) {
        better();
        old();
    }

    public static void better() {
        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("Alex Trotsky", "History"));
        students.add(new Student("Megan Cooper", "Computer Science"));


        System.out.println(students.get(0).SUBJECT);
    }

    public static void old() { 
        ArrayList<Student> students = new ArrayList<Student>();

        Student student1 = new Student("Alex Trotsky", "History");
        Student student2 = new Student("Megan Cooper", "Computer Science");
        
        students.add(student1);
        students.add(student2);


        System.out.println(student1.NAME);
        
    }


}

class Student {
    
    String NAME;
    String SUBJECT;

     public Student(String name, String subject) {
        this.NAME = name;
        this.SUBJECT = subject;
    }
}