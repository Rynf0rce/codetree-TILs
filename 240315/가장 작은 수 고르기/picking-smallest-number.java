import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_INT = 1000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = MAX_INT;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            ans = Math.min(ans, num);
        }
        System.out.print(ans);
    }
}