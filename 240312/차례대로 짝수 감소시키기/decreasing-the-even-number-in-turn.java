import java.util.*;

public class Main {
    public static int num = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0, sum = 0;
        for(int i = 2 ; i <= 1000 ; i++){
            if(i % 2 == 0){
                cnt++;
                sum += i;
                num -= i;
            }
            
            if(num <= n){
                break;
            }
        }
        System.out.print(cnt + " " + sum);
    }
}