import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                cnt += 2;
                if(cnt > 8){
                    cnt = 2;
                }
                System.out.print(cnt + " ");
            }
            System.out.println();
        }
    }
}