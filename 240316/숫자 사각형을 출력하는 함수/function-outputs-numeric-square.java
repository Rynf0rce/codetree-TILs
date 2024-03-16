import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < n ; j++){
                sb.append((i + n * j) + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}