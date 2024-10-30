import java.util.*;
import java.io.*;
public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            s.push(Integer.parseInt(st.nextToken()));
        }

        int ans = n - 1;
        int val = s.pop();
        while(!s.isEmpty() && s.peek() < val){
            ans--;
            val = s.pop();
        }
        System.out.print(ans);
    }
}