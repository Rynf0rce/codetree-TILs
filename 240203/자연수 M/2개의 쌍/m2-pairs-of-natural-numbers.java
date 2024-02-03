import java.util.*;
import java.io.*;

public class Main {
    public static TreeSet<Integer> ts = new TreeSet<>();
    public static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            hm.put(num, cnt);
            ts.add(num);
        }

        System.out.print(ts.first() + ts.last());

        // long minVal = Long.MAX_VALUE;
        // while(!hm.isEmpty()){
        //     hm.put(ts.first(), hm.get(ts.first()) - 1);
        //     hm.put(ts.last(), hm.get(ts.last()) - 1);

        //     if(hm.get(ts.first()) == 0){
        //         hm.remove(ts.first());
        //         br.remove(ts.first());
        //     }
        //     if()
        // }
        
    }
}