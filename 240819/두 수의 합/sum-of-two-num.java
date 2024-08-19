import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100000;
    public static int[] arr = new int[MAX_RANGE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);

            if(map.get(arr[i]) <= 0){
                map.remove(arr[i]);
            }

            int remain = k - arr[i];

            if(map.containsKey(remain)){
                cnt += map.get(remain);
            }
        }

        System.out.println(cnt);

    }
}