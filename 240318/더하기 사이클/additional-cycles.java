import java.util.*;

public class Main {

    public static int simul(int num){
        int first = num % 10;
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        return first * 10 + sum % 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curVal = n;
        int ans = 0;
        while(true){
            ans++;
            int calVal = simul(curVal);
            if(calVal == n){
                break;
            }
            curVal = calVal;
        }
        System.out.print(ans);

    }
}