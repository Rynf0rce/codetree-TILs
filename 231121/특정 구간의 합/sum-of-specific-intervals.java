import java.util.*;

public class Main {
    public static int[] cnt = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a1 = 0, a2 = 0, sum = 0;
        for(int i = 0 ; i < n ; i++){
            cnt[i] = sc.nextInt();
        }
        for(int i = 0 ; i < m ; i++){
            a1 = sc.nextInt();
            a2 = sc.nextInt();
            sum = 0;
            for(int j = a1 - 1 ; j <= a2 - 1 ; j++){
                sum += cnt[j];
            }
            System.out.println(sum);
        }
    }
}