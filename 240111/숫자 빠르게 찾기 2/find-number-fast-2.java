import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            s.add(num);
        }

        for(int i = 0 ; i < m ; i++){
            int num = sc.nextInt();
            System.out.println(s.ceiling(num) == null ? -1 : s.ceiling(num));
        }
    }
}