import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int n = 0;
        int cnt = 0;
        for(int i = A.length() - 1 ; i >= 0 ; i--){
            char c = A.charAt(i);
            if(c >= '0' && c <= '9'){
                n += (c - '0') * (int)Math.pow(10, cnt++);
            }
        }

        int m = 0;
        cnt = 0;
        for(int i = B.length() - 1 ; i >= 0 ; i--){
            char c = B.charAt(i);
            if(c >= '0' && c <= '9'){
                n += (c - '0') * (int)Math.pow(10, cnt++);
            }
        }

        System.out.print(n + m);

    }
}