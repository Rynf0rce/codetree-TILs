import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            long num = Long.parseLong(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0 + "\n");
                }
                else{
                    sb.append( (pq.poll() * -1) + "\n");
                }
            }
            else{
                pq.add(num * -1);
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}