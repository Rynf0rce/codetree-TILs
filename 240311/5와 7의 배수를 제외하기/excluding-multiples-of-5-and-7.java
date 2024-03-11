import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0, sum = 0;
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num % 5 == 0 || num % 7 == 0){
                continue;
            }
            cnt++;
            sum += num;
        }
        double avg = sum / cnt;
        System.out.println(sum);
        System.out.printf("%.1f", avg);
    }
}