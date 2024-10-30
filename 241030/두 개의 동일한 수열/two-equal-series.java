import java.util.*;
import java.io.*;

public class Main {
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            hs.add(num);
        }

        st = new StringTokenizer(br.readLine() , " ");
        boolean ans = true;
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!hs.contains(num)){
                ans = false;
                break;
            }
        }
        System.out.print(ans ? "Yes" : "No");
    }
}