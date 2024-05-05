import java.util.*;
import java.io.*;

public class Main {
    public static TreeSet<Integer> S_Set = new TreeSet<>();
    public static TreeSet<Integer> N_Set = new TreeSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine());
            char c = String.valueOf(st.nextToken()).charAt(0);
            int loc = Integer.parseInt(st.nextToken());
            if(c == 'S'){
                S_Set.add(loc);
            }
            else{
                N_Set.add(loc);
            }
        }

        int ans = 0;
        for(int i = a ; i <= b ; i++){
            int d1 = 2000;
            int d2 = 2000;
            if(S_Set.ceiling(i) != null){
                d1 = Math.abs(i - S_Set.ceiling(i));
            }

            if(S_Set.floor(i) != null){
                d1 = Math.min(d1, Math.abs(i - S_Set.floor(i)));
            }

            if(N_Set.ceiling(i) != null){
                d2 = Math.abs(i - N_Set.ceiling(i));
            }

            if(N_Set.floor(i) != null){
                d2 = Math.min(d2, Math.abs(i - N_Set.floor(i)));
            }

            if(d1 <= d2){
                ans++;
            }
        }
        System.out.print(ans);
    }
}