import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = Integer.MAX_VALUE;
    public static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            hm.put(x, Math.min(hm.getOrDefault(x, MAX_INT), y));
        }

        long ans = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            ans += entry.getValue();
        }
        System.out.printf("%d", ans);
    }
}