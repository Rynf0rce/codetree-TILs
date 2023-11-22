import java.util.*;

public class Main {
    public static int conFnc(int n){
        if(n <= 2){
            return n;
        }
        else{
            return conFnc(n-2) + n;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(conFnc(N));
    }
}