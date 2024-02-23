import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];
    public static int[] cnt = new int[MAX_NODE + 1];
    public static HashSet<Integer> rootSet = new HashSet<>();
    public static ArrayList<Integer> numList = new ArrayList<>();

    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        int rootIdx = find(uf[idx]);
        uf[idx] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            cnt[rootB] += cnt[rootA];
        }
        uf[rootA] = rootB;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            cnt[i] = 1;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) != find(b)){
                union(a, b);
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int rootA = find(A);
        int rootB = find(B);

        rootSet.add(rootA);
        rootSet.add(rootB);

        int ans = cnt[rootA];
        for(int i = 1 ; i <= n ; i++){
            int curIdx = find(i);
            if(!rootSet.contains(curIdx)){
                numList.add(cnt[curIdx]);
                rootSet.add(curIdx);
            }
        }

        Collections.sort(numList);
        for(int i = 0 ; i < Math.min(K, numList.size()) ; i++){
            ans += numList.get(i);
        }
        System.out.print(ans);
    }
}