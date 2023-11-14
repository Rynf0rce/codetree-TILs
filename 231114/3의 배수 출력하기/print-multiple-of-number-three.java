import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1;
        while(num <= n){
            if(num % 3 ==0){
                System.out.print(num + " ");
            }
            num++;
        }
    }
}