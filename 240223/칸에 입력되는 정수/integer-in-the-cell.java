import java.util.*;
import java.io.*;

public class Main {
    public static TreeSet<Integer> ballSet = new TreeSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            ballSet.add(i);
        }

        int m = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            int range = Integer.parseInt(br.readLine());
            if(ballSet.floor(range) == null){
                break;
            }
            else{
                ballSet.remove(ballSet.floor(range));
                ans++;
            }
        }
        System.out.print(ans);
    }
}