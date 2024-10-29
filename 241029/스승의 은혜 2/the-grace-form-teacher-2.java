import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        int ans = 0;
        for(int i = 0 ; i < arr.size() ; i++){
            int cnt = 0;
            int budget = B;
            for(int j = 0 ; j < arr.size() ; j++){
                int cost = i == j ? arr.get(j) / 2 : arr.get(j);

                if(budget - arr.get(j) >= 0){
                    cnt++;
                    budget -= cost;
                }
                else{
                    break;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}