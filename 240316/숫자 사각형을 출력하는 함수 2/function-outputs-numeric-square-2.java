import java.util.*;
public class Main {
    public static void printSquare(int n){
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(i * (int)Math.pow(2, j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printSquare(n);
    }
}