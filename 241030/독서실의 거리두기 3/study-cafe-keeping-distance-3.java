import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 1000;
    public static boolean[] arr = new boolean[MAX_LENGTH];
    public static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 1;
        for(int i = 1 ; i < n ; i++){
            if(str.charAt(i) == '0'){
                cnt++;
            }
            else{
                al.add(cnt);
                cnt = 1;
            }
        }

        Collections.sort(al);

        int ans = 0; // 최소의 최대
        for(int i = 0 ; i < al.size(); i++){
            int val = MAX_LENGTH;
            for(int j = 0 ; j < al.size() ; j++){
                int num = i == j ? al.get(j) / 2 : al.get(j);
                val = Math.min(val, num);
            }
            ans = Math.max(ans, val);
        }
        System.out.print(ans);
    }
}