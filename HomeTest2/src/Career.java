import java.util.Arrays;

public class Career {

    private int numExams=0;
    private double mean;
    static final int MAX_EXAMS = 5;
    private Exam[] studentExams = new Exam[MAX_EXAMS];


    public Career(){   //Empty constructor
        numExams = 0;
        mean = 0;
    }

    public void newExam(Exam e){
        if(numExams < MAX_EXAMS){

            studentExams[numExams] = e;
            numExams++;
        }
        else{
            System.out.println("Max exam quota reached");
        }
        computeMean(e);
    }


    public void computeMean(Exam e) {
        if (!e.getExamName().equals("NA") ) {
            mean = 0;
            for (int i = 0; i < numExams; i++) {
                mean += studentExams[i].getMark();
            }
            mean = mean / numExams;
        }
    }


    public static void delete(Exam e, Exam[] studentExams){ //method to delete an exam from student's career
       for(int i=0; i<MAX_EXAMS; i++){
           if(e.getExamName().equals(studentExams[i].getExamName())){
                studentExams[i+1] = studentExams[i];
           }
       }
    }


    @Override
    public String toString() {
        String e = "";
        for(int i=0; i < numExams; i++){
            e = e + studentExams[i].toString() + "\n";
        }
        String retn = "Mean= " + mean + ", number of exams=" + numExams + "\n" + e;
        return retn;
    }

    public static void main(String[] args) {
        Exam exam1 = new Exam("Math", 17, 2026, 03, 12);
        Exam exam2 = new Exam("CP1", 22, "22-03-2026");
        Exam exam3 = new Exam();
        Career studentCareer = new Career();

        studentCareer.newExam(exam1);
        studentCareer.newExam(exam2);
        studentCareer.newExam(exam3);

        System.out.println(studentCareer);
    }

}
