import java.util.*;

public class Main {
    public static int MAX_LENGTH = 30;
    public static long[][] DP = new long[MAX_LENGTH + 1][MAX_LENGTH + 1];

    public static long findAns(int a, int b){
        if(a > b){
            return findAns(b, a);
        }

        for(int i = a ; i <= b ; i++){
            DP[a][i] = 1;
        }

        for(int i = a + 1 ; i <= b ; i++){
            for(int j = a ; j <= b; j++){
                if(i <= j){
                    DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
                }
            }
        }

        return DP[b][b];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findAns(a,b));
    }
}