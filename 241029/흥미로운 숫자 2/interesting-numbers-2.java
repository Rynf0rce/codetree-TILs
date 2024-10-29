import java.util.*;
import java.io.*;
public class Main {
    public static HashSet<Character> hs = new HashSet<>();
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
            for(int j = 0 ; j < str.length() ; j++){
                hs.add(str.charAt(j));
            }

            if( hs.size() == 2 ){
                ans++;
            }
        }
        System.out.print(ans);
    }
}