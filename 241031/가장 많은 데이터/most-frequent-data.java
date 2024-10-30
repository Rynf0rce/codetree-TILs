import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            hm.put(str, hm.getOrDefault(str, 0) + 1);
            ans = Math.max(ans, hm.get(str));
        }
        System.out.print(ans);
    }
}