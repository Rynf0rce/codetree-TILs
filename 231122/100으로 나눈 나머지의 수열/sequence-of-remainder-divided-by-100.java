import java.util.*;

public class Main {
    public static int conFnc(int n){
        if(n == 1) return 2;
        else if(n == 2) return 4;
        else{
            return (conFnc(n-1)*conFnc(n-2)) % 100;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(conFnc(n));
    }
}