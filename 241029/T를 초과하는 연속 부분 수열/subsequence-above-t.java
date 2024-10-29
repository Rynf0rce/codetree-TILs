import java.util.*;
import java.io.*;

public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            
            if(num <= t){
                ans = Math.max(ans, s.size());
                s.clear();
            }
            else{
                s.push(num);
            }
        }
        System.out.print(Math.max(ans, s.size()));
    }
}