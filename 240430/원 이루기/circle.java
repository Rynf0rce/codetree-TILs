import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while(i < n){
            if(i % 2 == 1){
                System.out.print(1 + " ");
            }
            else{
                System.out.print(2 + " ");
            }
            i++;
        }
        if(i % 2 == 1){
            System.out.print(3);
        }
        else{
            System.out.print(2);
        }
    }
}