import java.util.*;

public class Main {
    public static void printSquare(int n, int m){
        int cnt = 1, range = n >= m ? m : n;
        for(int i = 1 ; i <= range ; i++){
            if(n % i == 0 && m % i == 0){
                cnt = i;
            }
        }
        System.out.print(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        printSquare(n, m);
    }
}