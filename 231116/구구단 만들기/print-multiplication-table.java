import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        for(int i = 1 ; i <= 9 ; i++){
            for(int j = b ; j >= a; j--){
                if(j % 2 != 0){
                    continue;
                }
                System.out.printf("%d * %d = %d", j, i, i*j);
                if(j > a){
                    System.out.print(" / ");
                }
            }
            System.out.println();
        }
    }
}