import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 2;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(j < i){
                    System.out.print("  ");
                }
                else{
                    System.out.print(num + " ");
                    num += 2;
                }
                
                if(num > 8){
                    num = 2;
                }
            }
            System.out.println();
        }
        
    }
}