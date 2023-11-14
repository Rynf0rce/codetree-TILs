import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        int n = sc.nextInt();
        if(c == 'A'){
            for(int i = 1 ; i <= n ; i++){
                System.out.print(i + " ");
            }
        }
        else if(c == 'D'){
            for(int i = n ; i >= 1 ; i--){
                System.out.print(i + " ");
            }
        }
    }
}