import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int ans = 0;
        int i = 0;
        int j = 0;
        while(A * i <= C){
            j = 0;
            while(A * i + B * j <= C){
                ans = Math.max(ans, A * i + B * j);
                j++;
            }
            i++;
        }
        System.out.print(ans);
    }
}