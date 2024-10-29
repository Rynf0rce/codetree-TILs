import java.util.*;
import java.io.*;

public class Main {
    public static TreeSet<Integer> sTree = new TreeSet<>();
    public static TreeSet<Integer> nTree = new TreeSet<>();
    public static final int INVALIED = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            int loc = Integer.parseInt(st.nextToken());
            if(c == 'S'){
                sTree.add(loc);
            }
            else{
                nTree.add(loc);
            }
        }

        // sdist <= ndist
        int ans = 0;
        for(int i = a ; i <= b ; i++ ){
            int sDist = Math.min( Math.abs(i - (sTree.ceiling(i) == null ? INVALIED : sTree.ceiling(i))) , Math.abs(i - (sTree.floor(i) == null ? INVALIED : sTree.floor(i))));
            int nDist = Math.min( Math.abs( i - (nTree.ceiling(i) == null ? INVALIED : nTree.ceiling(i))) , Math.abs(i - (nTree.floor(i) == null ? INVALIED : nTree.floor(i))));
            if(sDist <= nDist){
                ans++;
            }
        }
        System.out.print(ans);
    }
}