import java.util.*;
import java.io.*;

public class Main {
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            hs.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            System.out.print(hs.contains(Integer.parseInt(st.nextToken())) ? 1 + " " : 0 + " ");
        }
    }
}