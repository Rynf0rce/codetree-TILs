import java.util.*;

public class Main {
    public static final int MAX_INPUT = 100000;
    public static int[] arr = new int[MAX_INPUT];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int cnt = 0;

        for(int i = 0 ; i < n ; i++) {
            if (map.containsKey(k - arr[i])) {
                cnt += map.get(k - arr[i]);
            }

            if (k - arr[i] == arr[i]) {
                cnt--;
            }
        }

        System.out.println(cnt / 2);
    }
}