import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int num = a;
        while(num <= b){
            if(num % 2 ==0){
                System.out.print(num + " ");
            }
            num++;
        }
    }
}