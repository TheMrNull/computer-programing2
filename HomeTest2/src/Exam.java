import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exam {
    private int mark;
    private LocalDate dateOfExam;
    private String examName;
    private String lode;

    public Exam(String n, int m, LocalDate d){  //Standard constructor
        examName = n;
        mark = m;
        dateOfExam = d;
    }

    public Exam(String n, int m, int year, int month, int day){  //Date constructor
        examName = n;
        mark = m;
        dateOfExam = LocalDate.of(year,month,day);
    }


    public Exam(){   //Empty case constructor
        this("NA",0,2000,1,1);
    }

    public Exam(String n, int m, String date){  //Date format constructor
        examName = n;
        mark = m;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        dateOfExam = parsedDate;
    }


    public static void rename(Exam e, String newName){  //method to rename exam
        e.examName = newName;
    }




    @Override
    public String toString() {
        return "Exam{" +
                "mark=" + mark +
                ", dateOfExam=" + dateOfExam +
                ", examName='" + examName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Exam exam1 = new Exam("Math", 17, 2026, 03, 12);
        Exam exam2 = new Exam("CP1", 22, "22-03-2026");
        Exam exam3 = new Exam();
        System.out.println(exam1);
        System.out.println(exam2);
        System.out.println(exam3);


    }




    public int getMark() {
        return mark;
    }


    public void setMark(int mark) {
        this.mark = mark;
    }

    public LocalDate getDate() {
        return dateOfExam;
    }

    public void setDate(LocalDate dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String course) {
        this.examName= examName;
    }
}
