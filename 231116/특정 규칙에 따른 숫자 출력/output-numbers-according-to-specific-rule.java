import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n; j++){
                if(i <= j){
                    if(cnt < 9){
                        cnt++;
                    }
                    else{
                        cnt = 1;
                    }
                    System.out.print(cnt + " ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}