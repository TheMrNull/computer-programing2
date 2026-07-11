public class Filter {
    static double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5};
    static double sum = 0;
    public static void filterData(double[] arr){
        for(int i=0;i<5;i++){
            if(arr[i]<5.0){
                sum += arr[i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("First array: ");
        System.out.println("{1.1, 2.2, 3.3, 4.4, 5.5}");
        filterData(arr);
        System.out.println(sum);
    }
}
