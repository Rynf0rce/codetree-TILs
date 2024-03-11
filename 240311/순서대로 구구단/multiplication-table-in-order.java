import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i = 1 ; i <= 9 ; i++){
            if(a <= b){
                for(int j = a ; j <= b ; j++){
                    System.out.printf("%d * %d = %d  ", j, i, i * j);
                }
            }
            else{
                for(int j = a ; j >= b ; j--){
                    System.out.printf("%d * %d = %d  ",j, i, i * j);
                }
            }
            System.out.println();
        }
    }
}