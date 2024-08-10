import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NUM = 10;
    public static int[] arr = new int[MAX_NUM];
    public static HashSet<Integer> ansSet = new HashSet<>();

    public static void initialize(){
        for(int i = 0 ; i < MAX_NUM ; i++){
            arr[i] = 0;
        }
    }

    public static boolean isInterestedNum(int num){
        initialize();
        ansSet.clear();
        while(num > 0){
            int rest = num % 10;
            ansSet.add(rest);
            arr[rest]++;
            num /= 10;
        }

        if(ansSet.size() != 2){
            return false;
        }

        boolean flag = false;
        for(int inNum : ansSet){
            if(!flag && arr[inNum] >= 2){
                flag = true;
            }
            else if(flag && arr[inNum] >= 2){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i = X ; i <= Y ; i++){
            if(isInterestedNum(i)){
                ans++;
            }
        }
        System.out.print(ans);
    }
}