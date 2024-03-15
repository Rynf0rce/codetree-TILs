import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        double sum = 0;
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num % 7 == 0){
                cnt++;
                sum += num;
            }
        }
        System.out.printf("%d %d %.1f", cnt, (int)sum, sum / cnt);
    }
}