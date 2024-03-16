import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        int cnt = 0;

        while((int)Math.pow(m, cnt) < n){
            cnt++;
        }
        
        while(cnt-- > 0){
            if(m == 16){
                long num = n / (int)Math.pow(m, cnt);
                if(num >= 10){
                    System.out.print( (char)('a' + (num - 10)) );
                }
                else{
                    System.out.print(num);
                }
            }
            else{
                System.out.print(n / (int)Math.pow(m, cnt));
            }
            n = n % (int)Math.pow(m, cnt);
        }
    }
}