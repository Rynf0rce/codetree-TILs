import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int sum = 0, cnt = 0;
        for(int i = start ; i <= end ; i++){
            sum = 0;
            for(int j = 1 ; j < i ; j++){
                if(i % j == 0){
                    sum += j;
                }
            }
            if(sum == i){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}