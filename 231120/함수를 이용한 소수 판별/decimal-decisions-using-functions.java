import java.util.*;

public class Main {
    public static int fucPrime(int a, int b){
        int sum = 0, cnt = 0;
        for(int i = a ; i <= b ; i++){
            cnt = 0 ;
            for(int j = 1 ; j <= i ; j++){
                if(i%j == 0){
                    cnt++;
                }
            }
            if(cnt == 2){
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.print(fucPrime(a, b));
    }
}