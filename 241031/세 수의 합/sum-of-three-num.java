import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH];
    public static HashMap<Integer, Integer> hm = new HashMap<>();
    public static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) - 1);
            for(int j = i + 1; j < n ; j++){
                hm.put(arr[j], hm.getOrDefault(arr[j], 0) - 1);
                if(hm.getOrDefault(k - arr[i] - arr[j], 0) > 0){
                    ans += hm.get(k - arr[i] - arr[j]);
                    // System.out.println(arr[i] + " " + arr[j] + " " + ((k - arr[i] - arr[j])));
                }
                s.push(arr[j]);
            }
            while(!s.isEmpty()){
                int num = s.pop();
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }           
        }
        System.out.print(ans);
    }
}