import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        double avg = 0;
        for(int i = 1 ; i <= n ; i++){
            sum += sc.nextInt();
            if(sum > 200){
                avg = sum / i;
                break;
            }
        }
        System.out.println((int)sum);
        System.out.print(avg);
    }
}