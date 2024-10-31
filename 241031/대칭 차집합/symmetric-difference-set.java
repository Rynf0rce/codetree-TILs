import java.util.*;
import java.io.*;

public class Main {
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            hs.add(Integer.parseInt(st.nextToken()));
        }

        int ans = hs.size();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hs.contains(num)){
                ans--;
            }
            else{
                ans++;
            }
        }
        System.out.print(ans);
    }
}