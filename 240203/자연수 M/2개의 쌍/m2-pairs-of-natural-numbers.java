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

        // System.out.print(hm.get(ts.first()) + " " + hm.get(ts.last()));

        int ans = 0;
        if(hm.get(ts.first()) == hm.get(ts.last())){
            ans = ts.first() + ts.last();
        }
        else if(hm.get(ts.first()) > hm.get(ts.last())){
            int cnt = hm.get(ts.first());
            while(true){
                cnt -= hm.get(ts.last());
                if(cnt < 0){
                    ans = ts.first() + ts.last();
                    break;
                }
                ts.remove(ts.last());
            }
        }
        else{
            int cnt = hm.get(ts.last());
            while(true){
                cnt -= hm.get(ts.first());
                if(cnt < 0){
                    ans = ts.first() + ts.last();
                    break;
                }
                ts.remove(ts.first());
            }
        }


        bw.write( ans + "");

        br.close();
        bw.close();
        
    }
}