import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ans = -100;
        for(int i = 0 ; i < 3 ; i++){
            int num = sc.nextInt();
            ans = Math.max(ans, num);
        }
        System.out.print(ans);
    }
}