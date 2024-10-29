import java.util.*;
import java.io.*;

public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(s.isEmpty() || s.peek() < num){
                s.push(num);
            }
            else{
                ans = Math.max(ans, s.size());
                s.clear();
                s.push(num);
            }
        }
        System.out.print(Math.max(ans, s.size()));

    }
}