import java.util.*;

public class Main {
    public static int findGCD(int a, int b){
        if(a > b){
            return findGCD(b, a);
        }

        int ans = 1;
        for(int i = a ; i >= 1 ; i--){
            if(b % i == 0 && a % i == 0){
                ans = i;
                break;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = findGCD(a, b);
        System.out.print(gcd + " " + gcd * (a / gcd) * (b / gcd));   
    }
}