import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 10000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();
    public static HashSet<Integer> nodeNumSet = new HashSet<>();

    public static boolean BFS(int startIdx){
        q.clear();
        q.add(startIdx);
        while(!q.isEmpty()){
            int curIdx = q.poll();
            if(visited[curIdx]){
                continue;
            }

            visited[curIdx] = true;

            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                if(visited[postIdx]){
                    continue;
                }

                if(q.contains(postIdx)){
                    return false;
                }

                q.add(postIdx);
            }
            
        }

        for(Integer num : nodeNumSet){
            if(!visited[num]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 1 ; i <= MAX_NODE ; i++){
            nodeList[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        int startIdx = -1;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(startIdx == -1){
                startIdx = start;
            }
            nodeList[start].add(end);
            nodeList[end].add(start);
            nodeNumSet.add(start);
            nodeNumSet.add(end);
        }

        
        System.out.print(BFS(startIdx) ? 1 : 0);
    }
}