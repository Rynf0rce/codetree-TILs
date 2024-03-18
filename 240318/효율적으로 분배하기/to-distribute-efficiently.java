import java.util.*;

public class Main {
    public static final int MAX_INT = (int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = -1;
        for(int i = n / 5 ; i >= 0 ; i--){
            if( (n - i * 5) % 3 == 0 ){
                ans = i + (n - i * 5) / 3;
                break;
            }
        }

        System.out.print(ans);
    }
}