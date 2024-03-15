import java.util.*;
public class Main {
    public static int[] cnt = new int[11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            cnt[num / 10]++;
        }

        for(int i = 10 ; i >= 1 ; i--){
            if(cnt[i] == 0){
                continue;
            }
            System.out.printf("%d - %d\n", 10 * i , cnt[i]);
        }
    }
}