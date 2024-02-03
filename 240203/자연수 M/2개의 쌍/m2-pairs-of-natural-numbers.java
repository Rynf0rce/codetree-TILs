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

        long maxOfMin = 0;
        while(!ts.isEmpty()){
            maxOfMin = Math.max(ts.first() + ts.last(), maxOfMin);
            if(hm.get(ts.first()) > hm.get(ts.last())){
                hm.put(ts.first(), hm.get(ts.first()) - hm.get(ts.last()));
                ts.remove(ts.last());
            }
            else if(hm.get(ts.first()) < hm.get(ts.last())){
                hm.put(ts.last(), hm.get(ts.last()) - hm.get(ts.first()));
                ts.remove(ts.first());
            }
            else{
                ts.remove(ts.last());
                if(ts.isEmpty()){
                    break;
                }
                ts.remove(ts.first());
            }
        }

        bw.write(maxOfMin + "");

        br.close();
        bw.close();
        
    }
}