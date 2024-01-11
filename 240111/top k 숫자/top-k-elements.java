import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s = new TreeSet<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            s.add(num);
        }

        for(int i = 0 ; i < k ; i++){
            System.out.print(s.last() + " ");
            s.remove(s.last());
        }
    }
}