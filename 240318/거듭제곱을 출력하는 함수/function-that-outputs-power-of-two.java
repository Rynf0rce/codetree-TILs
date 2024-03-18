import java.util.*;

public class Main {
    public static int sqrt(int num, int cnt){
        if(cnt == 1){
            return num;
        }

        return num * sqrt(num, cnt - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(sqrt(n, m));
    }
}