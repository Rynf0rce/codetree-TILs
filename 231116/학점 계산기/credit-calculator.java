import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [] arr = new double[n];
        double sum = 0, average = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }
        
        average = (double)sum / n;
        System.out.printf("%.1f\n",average);   
        if(average >= 4.0){
            System.out.print("Perfect");
        }
        else if(average >= 3.0){
            System.out.print("Good");
        }
        else{
            System.out.print("Poor");
        }
    }
}