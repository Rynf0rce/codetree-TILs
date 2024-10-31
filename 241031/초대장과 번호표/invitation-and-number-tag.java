import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 250000;
    public static HashSet<Integer>[] hsArr = new HashSet[MAX_LENGTH];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < G ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            hsArr[i] = new HashSet<>();
            for(int j = 0 ; j < num ; j++){
                hsArr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        pq.add(1);
        int ans = 1;
        while(!pq.isEmpty()){
            int target = pq.poll();
            for(int i = 0 ; i < G ; i++){
                hsArr[i].remove(target);
                if(hsArr[i].size() == 1){
                    for(int num : hsArr[i]){
                        pq.add(num);
                    }
                    hsArr[i].clear();
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}