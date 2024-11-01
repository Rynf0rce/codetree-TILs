import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 20;
    public static int[] arr = new int[MAX_LENGTH];
    public static int n = 0;
    public static int ans = (int)1e9;
    public static int sum = 0;

    public static ArrayList<Integer> remiainArr = new ArrayList<>();

    public static void simulation(int idx, int cnt){
        if(cnt == n){
            int remain = 0;
            for(int num : remiainArr){
                remain += num;
            }
            ans = Math.min(ans, Math.abs(Math.abs(sum - remain) - remain)); 
            return;
        }

        if(idx > 2*n - 1){
            return;
        }

        remiainArr.add(arr[idx]);
        simulation(idx + 1, cnt + 1);
        remiainArr.remove(remiainArr.size() - 1);

        simulation(idx + 1, cnt);

        
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 2 * n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        simulation(0, 0);

        System.out.print(ans);
    }
}