import java.util.*;
import java.io.*;
public class Main {
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i = X ; i <= Y ; i++){
            int cnt1 = 0;
            int cnt2 = 0;
            String str = String.valueOf(i);
            hs.clear();
            int[] arr = new int[10];
            for(int j = 0 ; j < str.length() ; j++){
                hs.add(Integer.parseInt(str.charAt(j) + ""));
                arr[Integer.parseInt(str.charAt(j) + "")]++;
            }

            

            if( hs.size() == 2 ){
                boolean minor = false;
                boolean mul = false;
                for(Integer num : hs){
                    if(arr[num] == 1){
                        minor = true;
                    }
                    else if(arr[num] == str.length() - 1){
                        mul = true;
                    }
                }

                if(minor && mul){
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}