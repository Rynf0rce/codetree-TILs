import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static HashSet<Integer>[] inNodeSet = new HashSet[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static HashSet<Integer> ansSet = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= MAX_NODE; i++){
            nodeList[i] = new ArrayList<>();
            inNodeSet[i] = new HashSet<>();
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int nodeIdx = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < num ; j++){
                int neededIdx = Integer.parseInt(st.nextToken());
                nodeList[neededIdx].add(nodeIdx);
                inNodeSet[nodeIdx].add(neededIdx);
            }
        }

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < k ; i++){
            int inNode = Integer.parseInt(st.nextToken());
            pq.add(inNode);
        }


        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int curIdx = pq.poll();

            if(ansSet.contains(curIdx)){
                continue;
            }
            sb.append(curIdx + " ");
            ansSet.add(curIdx);
            
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                inNodeSet[postIdx].remove(curIdx);
                
                if(inNodeSet[postIdx].isEmpty()){
                    pq.add(postIdx);
                }
            }
        }

        System.out.println(ansSet.size());
        System.out.print(sb.toString());

        // System.out.println(ansSet.size());
        // ArrayList<Integer> ansList = new ArrayList<>(ansSet);
        // Collections.sort(ansList);
        // for(int i = 0 ; i < ansList.size() ; i++){
        //     System.out.print(ansList.get(i) + " ");
        // }

    }
}