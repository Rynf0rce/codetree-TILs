import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_DIST = 10000;
    public static int[] arr = new int[MAX_LENGTH];
    public static ArrayList<Integer> calList = new ArrayList<>();

    public static int calDist(){
        int i = -1;
        int ans = 0;
        for(Integer num : calList){
            if(i == -1){
                i = num;
                continue;
            }
            
            ans += Math.abs(num - i);
            i = num;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = MAX_DIST;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j){
                    continue;
                }
                for(int k = 0 ; k < n ; k++){
                    if(k == i){
                        continue;
                    }

                    if(k == j){
                        calList.add(arr[k] * 2);
                    }
                    else{
                        calList.add(arr[k]);
                    }
                }
                ans = Math.min(ans, calDist());
                calList.clear();
            }
        }
        System.out.print(ans);
    }
        
}