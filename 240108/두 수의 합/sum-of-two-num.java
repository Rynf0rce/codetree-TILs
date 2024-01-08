import java.util.*;

public class Main {
    public static int MAX_INPUT = 100000;
    public static int[] arr = new int[MAX_INPUT];

    public static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> inMap = new HashMap<>();

        n = sc.nextInt();
        k = sc.nextInt();

        int cnt = 0;

        for(int i = 1 ; i <= n ; i++){
            int value = sc.nextInt();
            inMap.put(i, value);
        }

        for(int i = 1 ; i <= n ; i++){
            if(inMap.containsValue( k - inMap.get(i) )){
                cnt++;
            }
        }

        System.out.println(cnt / 2);
    }
}