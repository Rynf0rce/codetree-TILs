import java.util.*;

public class Main {
    public static int fucPrime(int a, int b){
        int sum = 0;
        boolean chack = false;
        for(int i = a ; i <= b ; i++){
            chack = true ;
            for(int j = 2 ; j < a ; j++){
                if(i%j == 0){
                    chack = false;
                    break;
                }
            }
            if(chack){
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.print(fucPrime(a, b));
    }
}