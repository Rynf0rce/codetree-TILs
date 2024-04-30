import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static boolean[] primeArr = new boolean[MAX_LENGTH + 1];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 2 ; i <= n ; i++){
            if(primeArr[i]){
                continue;
            }

            for(int j = 2 * i ; j <= n ; j += i){
                primeArr[j] = true;
            }
        }

        int ans = 0;
        for(int i = 2 ; i <= n ; i++){
            if(!primeArr[i]){
                ans ++;
            }
        }

        System.out.println(ans);
    }
}