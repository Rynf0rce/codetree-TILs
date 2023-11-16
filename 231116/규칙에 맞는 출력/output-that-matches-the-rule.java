import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            for(int j = n - i + 1 ; j <= n; j++){
                if(i>=n - j){
                    System.out.print(j + " ");
                }
                else{
                    break;
                }
            }
            System.out.println();
        }
    }
}