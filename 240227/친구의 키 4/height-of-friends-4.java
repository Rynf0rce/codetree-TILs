import java.util.*;
import java.io.*;

class path{
    int start, end;
    public path(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int hashCode() {
        return (start + 1) * 100000 + end;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof path)) return false;
        path o = (path) obj;
        return o.start == this.start && o.end == this.end;
    }
}

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] panIn = new int[MAX_NODE + 1];
    public static path[] pathArr = new path[MAX_NODE + 1];
    public static HashSet<path> pathSet = new HashSet<>();
    public static Queue<Integer> q = new LinkedList<>();
    public static boolean[] visited = new boolean[MAX_NODE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        
        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pathArr[i] = new path(start, end);
            nodeList[start].add(end);
            panIn[end]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] == 0){
                q.add(i);
            }
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int curIdx = q.poll();
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                cnt++;
                panIn[postIdx]--;
                pathSet.add(new path(curIdx, postIdx));
                if(panIn[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }

        if(cnt == n){
            System.out.print("Consistent");
        }
        else{
            for(int i = 1 ; i <= n ; i++){
                if(pathSet.contains(pathArr[i])){
                    continue;
                }
                
                if(visited[pathArr[i].start] && visited[pathArr[i].end]){
                    System.out.print(i);
                    break;
                }
                visited[pathArr[i].start] = true;
                visited[pathArr[i].end] = true;
            }
        }
    }
}