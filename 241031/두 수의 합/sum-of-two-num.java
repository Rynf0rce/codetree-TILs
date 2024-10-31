import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static long[] arr = new long[MAX_LENGTH + 1];
    public static HashMap<Long, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(hm.get(arr[i]) <= 0 || hm.getOrDefault(k - arr[i], 0 ) <= 0){
                continue;
            }

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) - 1);
            ans += hm.get(k - arr[i]);
        }
        System.out.print(ans);
    }
}