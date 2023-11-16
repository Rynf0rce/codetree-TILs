import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            cnt = 0;
            for(int j = 1 ; j <= n ; j++){
                if(i % j == 0){
                    cnt++;
                    if(cnt > 3){
                        break;
                    }
                }
            }
            if(cnt == 2){
                System.out.print(i + " ");
            }
        }
    }
}