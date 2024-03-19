import java.util.*;

public class Main {
    public static int ans = 4;
    public static void findAns(int num, int cnt){
        if(cnt > 4){
            return;
        }

        for(int i = (int)Math.sqrt(num) ; i >= 1 ; i--){
            if(num - i * i == 0){
                ans = Math.min(ans, cnt);
                return;
            }

            if(num - i * i > 0){
                findAns(num - i * i, cnt + 1);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        findAns(n, 1);
        System.out.print(ans);
    }
}