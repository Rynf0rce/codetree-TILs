import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i = 0; i <= 20 ; i++){
            System.out.print(a/b);
            if(i == 0){
                System.out.print(".");
            }
            // a = ( a - b * (a/b) ) * 10;
            a = (a%b)*10;
        }
    }
}