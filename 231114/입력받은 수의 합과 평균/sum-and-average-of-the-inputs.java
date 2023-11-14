import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input = 0;
        int sumVal = 0;
        double averageVal = 0;
        for(int i = 0 ; i < n ; i++){
            input = sc.nextInt();
            sumVal += input;
        }
        averageVal = (double)sumVal / n;
        System.out.printf("%d %.1f", sumVal, averageVal);

    }
}