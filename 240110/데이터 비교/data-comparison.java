import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> s1 = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            s1.add(num);
        }

        int m = sc.nextInt();
        for(int i = 0 ; i < m ; i++){
            int num = sc.nextInt();
            System.out.print(s1.contains(num) ? "1 " : "0 ");
        }
    }
}