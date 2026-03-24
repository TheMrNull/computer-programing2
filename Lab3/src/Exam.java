
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exam {

    private int mark; // mark of an exam
    private String examName; // name of exam
    private LocalDate dateOfExam; // when the exam was taken


    public Exam(String n, int m, LocalDate d){   // Constructor
        examName = n;
        mark = m;
        dateOfExam = d;
    }

    public Exam(String n, int m, int year, int month, int day){   // Constructor for date format
        examName = n;
        mark = m;
        dateOfExam = LocalDate.of(year, month, day);
    }

    public Exam(){ // Default constructor
        this("NA",0,1970,1,1);
    }

    public Exam(String n, int m, String data){
        examName = n;
        mark = m;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");   // copied from slide 26 of  classOfClasses pdf on moodle
        LocalDate parsedDate = LocalDate.parse(data, formatter);
        dateOfExam = parsedDate;
    }


    @Override
    public String toString() {
        return "Exam{" +
                "mark=" + mark +
                ", examName='" + examName + '\'' +
                ", dateOfExam=" + dateOfExam +
                '}';
    }

    public static void main(String[] args) {
        Exam e01 = new Exam();
        Exam e02 = new Exam("CP2",27,"2025-01-03");
        Exam e03 = new Exam("CP3",18,"2025-02-03");
        Exam e04 = new Exam("CP4",23,"2025-03-03");
        Exam e05 = new Exam("CP5",30,"2025-05-07");
        System.out.println(e01);
        System.out.println(e02);
        System.out.println(e03);
        //Student s01 = new Student("Gigino","Gigetto",123456);
        //s01.insertExam(e02);
        //s01.insertExam(e03);
        //s01.insertExam(e05);
        //System.out.println(s01);
    }


    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public LocalDate getDateOfExam() {
        return dateOfExam;
    }

    public void setDateOfExam(LocalDate dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

}

