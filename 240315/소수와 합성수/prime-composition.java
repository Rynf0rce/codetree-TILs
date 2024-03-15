import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();

        if(num == 1){
            System.out.print("one");
            System.exit(0);
        }

        boolean flag = false;
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                flag = true;
                break;
            }
        }

        System.out.print(flag ? "composition" : "prime");
    }
}