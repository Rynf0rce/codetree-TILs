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
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(str.charAt(i) == '0'){
                cnt++;
            }
            else{
                al.add(cnt + 1);
                cnt = 0;
            }
        }

        Collections.sort(al);

        int ans = 0;
        for(int num : al){
            ans = Math.max(ans, num / 2);
        }

        System.out.print(ans);
    }
}