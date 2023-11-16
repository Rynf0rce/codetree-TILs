import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int cnt = 0, total = 0;
        for(int i = start ; i <= end ; i++){
            cnt = 0;
            for(int j = 1 ; j <= i ; j++){
                if(i % j == 0){
                    cnt++;
                    if(cnt > 3){
                        break;
                    }
                }
            }
            if(cnt == 3){
                total++;
            }
        }
        System.out.print(total);
    }
}