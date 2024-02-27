import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] fanIn = new int[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static PriorityQueue<Integer> ansPQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int composedIdx = Integer.parseInt(st.nextToken());
            int neededNum = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < neededNum ; j++){
                int neededIdx = Integer.parseInt(st.nextToken());
                nodeList[neededIdx].add(composedIdx);
                fanIn[composedIdx]++;
            }
        }

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < num ; i++){
            int curIdx = Integer.parseInt(st.nextToken());
            pq.add(curIdx);
            visited[curIdx] = true;
            ansPQ.add(curIdx);
        }

        while(!pq.isEmpty()){
            int curIdx = pq.poll();

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                if(visited[postIdx]){
                    continue;
                }

                fanIn[postIdx]--;
                if(fanIn[postIdx] == 0){
                    visited[postIdx] = true;
                    pq.add(postIdx);
                    ansPQ.add(postIdx);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ansPQ.size() + "\n");
        while(!ansPQ.isEmpty()){
            sb.append(ansPQ.poll() + " ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}