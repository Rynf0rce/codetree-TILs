import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(k == 1){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 0 ; j < n ; j++){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        else if(k == 3){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= n ; j++){
                    System.out.print( j * i + " ");
                }
                System.out.println();
            }
        }
        else{
            int num = 1;
            boolean triger = true;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(triger){
                        System.out.print(num++ + " ");
                    }
                    else{
                        System.out.print(num-- + " ");
                    }
                }
                System.out.println();
                if(triger){
                    triger = false;
                    num = n;
                }
                else{
                    triger = true;
                    num = 1;
                }
            }
        }
    }
}