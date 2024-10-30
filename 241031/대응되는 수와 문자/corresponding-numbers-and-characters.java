import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<String> arr = new ArrayList<>();
    public static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            String str = br.readLine();
            arr.add(str);
            hm.put(str, i);
        }

        for(int i = 0 ; i < m ; i++){
            String str = br.readLine();
            if('0' <= str.charAt(0) && str.charAt(0) <= '9'){
                System.out.println(arr.get(Integer.parseInt(str) - 1));
            }
            else{
                System.out.println(hm.get(str));
            }
        }
    }
}