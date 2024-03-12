import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        boolean triger = false;
        for(int i = 1 ; i <= 2 * n - 1 ; i++){
            if(cnt == n){
                triger = true;
            }
            
            for(int j = 0 ; j < cnt ; j++){
                System.out.print("*");
            }
            System.out.println();

            if(triger){
                cnt--;
            }
            else{
                cnt++;
            }
        }
    }
}