import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 9;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(num + " ");
                num -= 2;
                if(num < 0){
                    num = 9;
                }
            }
            System.out.println();
        }
    }
}