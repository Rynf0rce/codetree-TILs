import java.util.*;
import java.io.*;
public class Main {
    public static final int LENGTH = 3;
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int cnt = 0;
        int val = 0;
        int num = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            cnt = 0;
            q.clear();
            for(int j = 0 ; j < n ; j++){
                if(q.size() == LENGTH){
                    if(q.poll() == 1){
                        cnt--;
                    }
                }
                num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    cnt++;
                }
                q.add(num);
                val = Math.max(val, cnt);
            }
        }
        System.out.print(val);
    }
}