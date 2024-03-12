import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1 ; i <= n ; i++){
            int num = sc.nextInt();
            if(i % 2 == 0){
                sum += num;
            }
        }
        double avg = (double)sum / (n / 2);
        System.out.printf("%d %.1f", sum, avg);
    }
}