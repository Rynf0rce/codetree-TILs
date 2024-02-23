import java.util.*;
import java.io.*;

public class Main {
    public static HashSet<Integer> nodeSet = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeSet.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j = b ; j > a ; j--){
                nodeSet.remove(j);
            }
            sb.append(nodeSet.size() + "\n");
        }
        bw.write(sb.toString());
        
        br.close();
        bw.close();
    }
}