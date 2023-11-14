import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            if((i % 10) % 3 == 0 || (i % 100) % 30 == 0){
                System.out.print("0 ");
            }
            else{
                System.out.print(i + " ");
            }
        }
    }
}