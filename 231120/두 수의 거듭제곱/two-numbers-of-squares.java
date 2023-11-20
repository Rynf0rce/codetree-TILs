import java.util.*;

public class Main {
    public static int nthPower(int a, int b){
        int output = 1;
        if(b ==0){
            return 1;
        }
        for(int i = 0 ; i < b ; i++){
            output *= a;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.print(nthPower(a,b));
    }
}