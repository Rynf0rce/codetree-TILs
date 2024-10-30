import java.util.*;
import java.io.*;


public class Main {
    public static HashMap<Integer,Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!hm.containsKey(num)){
                hm.put(num, 1);
            }
            else{
                hm.put(num, hm.get(num) + 1);
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            int num = Integer.parseInt(st.nextToken());
            System.out.print(hm.get(num) == null ? 0 : hm.get(num) + " ");
        }
    }
}