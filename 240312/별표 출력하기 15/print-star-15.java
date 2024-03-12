import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean triger = true;
        StringBuilder sb = new StringBuilder();
        for(int i = n ; i >= 1 ; i--){
            for(int j = 0 ; j < i ; j++){
                sb.append("**");
            }
            sb.append("\n");
        }

        for(int i = 2 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                sb.append("**");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    
    }
}