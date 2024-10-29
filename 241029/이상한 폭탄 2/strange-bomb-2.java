import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = -1;
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(!map.containsKey(num)){
                map.put(num, i);
            }
            else{
                if(i - map.get(num) <= K){
                    ans = Math.max(ans, num);
                }
                map.put(num, i);
            }
        }
        System.out.print(ans);
    }
}