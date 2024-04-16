import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        for(int i = X ; i <= Y ; i++){
            String str = String.valueOf(i);
            int sum = 0;
            for(int j = 0 ; j < str.length() ; j++){
                sum += (str.charAt(j) - '0');
            }
            ans = Math.max(ans, sum);
        }
        System.out.print(ans);
    }
}