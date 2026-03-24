public class Student {
    private String name;
    private String surname;
    private int id;
    private Career studentCareer;


    public Student(int id, String n){
        this.name = n;
        this.id = id;
        this.studentCareer = new Career();

    }

    public Student(String name, String surname, int id){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.studentCareer = new Career();

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", studentCareer=" + studentCareer +
                '}';
    }

    public static void main(String[] args) {
        Exam exam1 = new Exam("Math", 17, 2026, 03, 12);
        Exam exam2 = new Exam("CP1", 22, "22-03-2026");
        Exam exam3 = new Exam();


        Student s01 = new Student("Alice", "Wong", 224455);
        s01.getStudentCareer().newExam(exam1);
        s01.getStudentCareer().newExam(exam2);
        System.out.println(s01);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Career getStudentCareer() {
        return studentCareer;
    }

    public void setStudentCareer(Career studentCareer) {
        this.studentCareer = studentCareer;
    }
}
