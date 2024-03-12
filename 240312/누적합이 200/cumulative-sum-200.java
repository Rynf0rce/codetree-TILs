import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        float avg = 0;
        for(int i = 1 ; i <= n ; i++){
            sum += sc.nextInt();
            if(sum > 200){
                avg = (float)sum / i;
                break;
            }
        }
        System.out.println(sum);
        System.out.printf("%.1f", avg);
    }
}