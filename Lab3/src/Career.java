import java.util.Arrays;

public class Career {
    private double mean; // mean mark of all exams
    static final int MAX_EXAM = 5; // dim of the vector
    private Exam[] career = new Exam[MAX_EXAM];
    private int num_exams=0;

    public Career(){
        num_exams = 0;
        mean=0;
    }
    public void newExam(Exam e) {
        if (num_exams < MAX_EXAM) {
            career[num_exams] = e;
            num_exams++;
        }
        else{
            System.out.println("Too many exams brochacho, quit studying");
        }
        computeMean();
    }

    private void computeMean(){
        mean=0;
        for(int i=0; i<num_exams;i++){
            mean += career[i].getMark();
        }
        mean = mean/num_exams;
    }

    @Override
    public String toString() {

        String e = "";
        for(int i=0; i<num_exams;i++){             //writing exams in string
            e = e + career[i].toString() + "\n";
        }

        String ret =  "Career{" +
                "mean=" + mean + ", num_exams=" + num_exams + "\n" + e +
                '}';
        return ret;
    }


    public static void main(String[] args) {
        Exam e01 = new Exam();
        Exam e02 = new Exam("CP2",27,"2026-01-03");
        Exam e03 = new Exam("CP3",18,"2025-02-03");
        Exam e04 = new Exam("CP4",23,"2024-03-03");
        Exam e05 = new Exam("CP5",30,"2022-05-07");
        Career myCareer = new Career();

        myCareer.newExam(e02);
        myCareer.newExam(e03);
        myCareer.newExam(e04);
        myCareer.newExam(e05);
        myCareer.newExam(new Exam("CP77",30,"2025-02-27"));
        System.out.println(myCareer);
    }


}
