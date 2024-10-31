import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = Integer.MAX_VALUE;
    public static final int MIN_INT = Integer.MIN_VALUE;
    public static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            Integer num = Integer.parseInt(st.nextToken());
            
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        int same = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            double d = k - entry.getKey();
            if(MIN_INT > d && d > MAX_INT){
                continue;
            }


            if(hm.containsKey((int)d)){
                if((int)d * 2 == k){
                    same += (entry.getValue() * (entry.getValue() - 1) / 2);
                }
                else{
                    ans += entry.getValue();
                }
            }
        }
        System.out.print( (ans / 2) + same);
    }
}