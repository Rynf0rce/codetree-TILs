import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fiveCnt = 0, sevenCnt = 0;
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num % 5 == 0){
                fiveCnt++;
            }

            if(num % 7 == 0){
                sevenCnt++;
            }
        }
        System.out.println(fiveCnt);
        System.out.println(sevenCnt);
    }
}