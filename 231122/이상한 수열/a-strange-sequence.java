import java.util.*;

public class Main {
    public static int conFnc(int n){
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else{
            return (conFnc(n/3) + conFnc(n-1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(conFnc(n));
    }
}