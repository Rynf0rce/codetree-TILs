import java.util.*;

public class Main {
    public static void commonMultiple(int n, int m){
        int cnt = 1, range = n >= m ? m : n, restN = 0, restM =0;
        for(int i = 1 ; i <= range ; i++){
            if(n % i == 0 && m % i == 0){
                cnt = i;
            }
        }
        restN = n / cnt;
        restM = m / cnt;
        System.out.print(cnt*restN*restM);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        commonMultiple(n, m);
    }
}