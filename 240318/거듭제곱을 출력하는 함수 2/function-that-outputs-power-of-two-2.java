import java.util.*;

public class Main {
    public static int pow(int num, int cnt){
        if(cnt <= 0){
            return 1;
        }

        return num * pow(num, cnt - 1);
    }

    public static int abs(int num){
        if(num < 0){
            return num * -1;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int first = pow(n, m);
        int second = pow(m, n);
        System.out.print(abs(second - first));
    }
}