import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 10000;
    public static boolean[] primeArr = new boolean[MAX_LENGTH + 1];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i = 2 ; i <= b ; i++){
            for(int j = 2 * i ; j <= b ; j += i){
                primeArr[j] = true;
            }
        }

        int ans = 0;
        int minVal = 0;
        for(int i = Math.max(2, a) ; i <= b ; i++){
            if(!primeArr[i]){
                ans += i;
                if(minVal == 0){
                    minVal = i;
                }
            }
        }

        System.out.println((ans == 0) ? -1 : ans);
        System.out.println((ans == 0) ? "" : minVal);
    }
}