import java.util.*;
import java.io.*;

class path{
    int start, end;
    public path(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static path[] pathArr = new path[MAX_NODE + 1];
    public static int[] panIn = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();
    public static int n = -1;

    public static boolean inCycle(int range){
        q.clear();
        for(int i = 1 ; i <= n ; i++){
            panIn[i] = 0;
            nodeList[i].clear();
        }

        for(int i = 1 ; i <= range ; i++){
            path p = pathArr[i];
            nodeList[p.start].add(p.end);
            panIn[p.end]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curIdx = q.poll();
            for(int i = 0 ; i < nodeList[curIdx].size(); i++){
                int postIdx = nodeList[curIdx].get(i);
                panIn[postIdx]--;
                if(panIn[postIdx] == 0){
                    q.add(postIdx);
                }
            }
        }

        boolean output = false;
        for(int i = 0 ; i <= n ; i++){
            if(panIn[i] != 0){
                output = true;
                break;
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }
        
        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pathArr[i] = new path(start, end);
        }

        int left = 1;
        int right = m;
        int ans = MAX_NODE + 1;
        while(left <= right){
            int mid = (right + left) / 2;
            if(inCycle(mid)){
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.print(ans == MAX_NODE + 1 ? "Consistent" : ans);
    }
}