import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static int[] arr = new int[MAX_LENGTH];
    public static ArrayList<Integer> selected = new ArrayList<>();

    public static int n = 0;
    public static int m = 0;
    public static int ans = 0;

    public static int cal(){
        int num = selected.get(0);
        for(int i = 1 ; i < selected.size() ; i++){
            num = num ^ selected.get(i);
        }
        return num;
    }

    public static void simulate(int idx, int cnt){
        if(idx >= m){
            if(cnt == m){
                ans = Math.max(ans, cal());
            }
            return;
        }

        for(int i = 0 ; i < n ; i++){
            
            simulate(idx + 1, cnt);
            
            selected.add(arr[i]);
            simulate(idx + 1, cnt + 1);
            selected.remove(selected.size() - 1);
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        simulate(0, 0);
        System.out.print(ans);
    }
}