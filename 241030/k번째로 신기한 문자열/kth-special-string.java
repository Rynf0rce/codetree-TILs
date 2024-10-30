import java.util.*;
import java.io.*;
public class Main {
    public static PriorityQueue<String> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String T = st.nextToken();

        for(int i = 0 ; i < n ; i++){
            pq.add(br.readLine());
        }

        while(!pq.isEmpty()){
            String s = pq.poll();
            if(s.length() >= T.length() && s.substring(0, T.length()).equals(T)){
                k--;
            }

            if(k == 0){
                System.out.print(s);
                System.exit(0);
            }
        }
    }
}