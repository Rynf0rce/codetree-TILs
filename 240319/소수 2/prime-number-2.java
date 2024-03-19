import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static boolean[] arr = new boolean[MAX_LENGTH + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for(int i = 2 ; i <= n ; i++){
            if(!arr[i]){
                cnt++;
            }
            for(int j = i ; j <= n ; j += i){
                arr[j] = true;
            }
        }
        System.out.print(cnt);
    }
}