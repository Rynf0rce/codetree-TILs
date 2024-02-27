import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] panIn = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m1 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            panIn[end]++;
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

        boolean flag = false;
        for(int i = 1 ; i <= n ; i++){
            if(panIn[i] > 0){
                flag = true;
                break;
            }
        }

        System.out.print(flag ? "No" : "Yes");
    }
}