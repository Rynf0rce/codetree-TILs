import java.util.*;
public class Main {
    public static HashSet<Integer> ansSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int cnt = 0;
        int num = N;
        while(!ansSet.contains((num * N) % P)){
            num = (num * N) % P;
            ansSet.add(num);
            cnt++;
        }
        System.out.print(cnt);

    }
}