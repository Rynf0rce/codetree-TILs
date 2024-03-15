import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c = 'A';
        int num = 1;
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= n ; j++){
                if(j <= i){
                    System.out.print(c++ + " ");
                }
                else{
                    System.out.print(num++ + " ");
                }

                if(c > 'Z'){
                    c = 'A';
                }

                if(num > 9){
                    num = 1;
                }
            }
            System.out.println();
        }
    }
}