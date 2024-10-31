import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Character> pq = new PriorityQueue<>();
    public static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < str.length(); j++){
                pq.add(str.charAt(j));
            }

            String ppap = "";
            while(!pq.isEmpty()){
                ppap += pq.poll() + "";
            }
            hm.put(ppap, hm.getOrDefault(ppap, 0) + 1);
            ans = Math.max(ans, hm.get(ppap));
        }
        System.out.print(ans);
    }
}