import java.util.*;

public class Main {
    public static void printTable(int idx){
        for(int i = 1 ; i <= 9 ; i++){
            System.out.printf("%d * %d = %d  ", idx, i, idx * i);
            if(i % 3 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = a ; i <= b ; i++){
            printTable(i);
        }

        for(int i = a ; i >= b ; i--){
            printTable(i);
        }
    }
}