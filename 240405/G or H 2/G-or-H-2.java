import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int minLoc = MAX_LENGTH;
        int maxLoc = 0;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int loc = Integer.parseInt(st.nextToken());
            char c = String.valueOf(st.nextToken()).charAt(0);
            if(c == 'G'){
                arr[loc] = 1;
            }
            else{
                arr[loc] = 2;
            }

            minLoc = Math.min(loc, minLoc);
            maxLoc = Math.max(loc, maxLoc);
        }

        
        int ans = 0;
        for(int i = minLoc ; i < maxLoc ; i++){
            if(arr[i] == 0){
                continue;
            }

            for(int j = 0 ; j < 3 ; j++){
                cnt[j] = 0;
            }

            for(int j = i ; j <= maxLoc ; j++){
                cnt[arr[j]]++;
                if(arr[j] > 0 && cnt[1] == cnt[2]){
                    ans = Math.max(j - i, ans);
                }
            }
        }

        System.out.print(ans);
    }
}