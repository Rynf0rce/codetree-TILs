import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            left = Integer.parseInt(st.nextToken());
            if(str.equals("add")){
                right = Integer.parseInt(st.nextToken());
                hm.put(left, right);
            }
            else if(str.equals("find")){
                System.out.println(hm.get(left) == null ? "None" : hm.get(left));
            }
            else if(str.equals("remove")){
                hm.remove(left);
            }
        }
    }
}