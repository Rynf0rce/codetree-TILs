import java.util.*;

public class Main {
    public static final int MAX_INT = 40;
    public static int[][] DP = new int[2][MAX_INT + 1];
    public static int cnt_zero = 0;
    public static int cnt_one = 0;

    public static int codetree(int n){
        if(n == 0){
            cnt_zero++;
            return 0;
        }
        else if(n == 1){
            cnt_one++;
            return 1;
        }
        else{
            return codetree(n - 1) + codetree(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        codetree(n);
        System.out.print(cnt_zero + " " + cnt_one);
    }
}