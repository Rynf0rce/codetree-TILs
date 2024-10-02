import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_CNT = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        char[] inArr = br.readLine().toCharArray();
        char[] targetArr = br.readLine().toCharArray();

        int ans = 0;
        int cnt = 0;
        boolean triger = false;
        for(int i = 0 ; i < n ; i++){
            if(inArr[i] != targetArr[i]){
                cnt++;
            }
            else{
                if(cnt > 0){
                    cnt = 0;
                    ans++;
                }
            }

            if(cnt >= MAX_CNT){
                ans++;
                cnt = 0;
            }
        }

        if(cnt > 0){
            ans++;
        }

        System.out.print(ans);
    }
}