import java.util.*;
import java.io.*;

public class Main {
    public static TreeMap<String, Integer> ansMap = new TreeMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 1;
        int n = Integer.parseInt(st.nextToken());
        String str = String.valueOf(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(str.charAt(i));
        }

        ansMap.put(sb.toString(), 1);

        for(int i = 1 ; i <= str.length() - n ; i++){
            sb.deleteCharAt(0);
            sb.append(str.charAt(i + n - 1));
            ansMap.put(sb.toString(), ansMap.getOrDefault(sb.toString(), 0) + 1);
            ans = Math.max(ansMap.get(sb.toString()), ans);
        }

        System.out.print(ans);
    }
}