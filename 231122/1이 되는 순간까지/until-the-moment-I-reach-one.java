import java.util.*;

public class Main {
    public static int nToOne(int n){
        if(n <= 1){
            return 0;
        }
        else
        {
            if(n % 2 == 0){
                return nToOne(n/2) + 1;
            }
            else{
                return nToOne(n/3) + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(nToOne(N));
    }
}