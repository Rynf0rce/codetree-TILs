import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n ; i > 0 ; i--){
            for(int j = 1 ; j <= 2*n ; j++){
                if(j <= i | j > 2*n -i)
                {
                   System.out.print("*"); 
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}