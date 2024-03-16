import java.util.*;

public class Main {
    public static double[] arr = new double[3];

    public static void printAns(){
        double ans = 0;
        for(int i = 0 ; i < 3 ; i++){
            ans += arr[i];
        }

        System.out.printf("%.0f\n%.0f", ans, ans / 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextDouble();
        }
        printAns();
    }
}