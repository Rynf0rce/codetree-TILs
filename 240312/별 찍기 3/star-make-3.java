import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j < cnt ; j++){
                System.out.print(" ");
            }
            for(int j = 0 ; j < 2 * cnt - 1 ; j++){
                System.out.print("*");
            }
            System.out.println();

            if(i - 1 >= n / 2){
                cnt--;
            }
            else{
                cnt++;
            }
        }
    }
}