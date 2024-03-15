import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c = 'A';
        int num = 0;
        for(int i = 0 ; i <= n ; i++){
            for(int j = n - 1 ; j >= 0 ; j--){
                if(i <= j){
                    System.out.print(c++ + " ");
                }
                else{
                    System.out.print(num++ + " ");
                }

                if(c > 'Z'){
                    c = 'A';
                }
                
                if(num > 9){
                    num = 0;
                }
            }
            System.out.println();
        }
    }
}