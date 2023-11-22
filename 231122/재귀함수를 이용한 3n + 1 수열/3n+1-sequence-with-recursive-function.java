import java.util.*;

public class Main {
    public static int conFnc(int n){
        if(n <= 1){
            return 0;
        }
        else{
            if(n%2 == 0){
                return conFnc(n/2) + 1;
            }
            else{
                return conFnc(3*n+1) + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(conFnc(n));
    }
}