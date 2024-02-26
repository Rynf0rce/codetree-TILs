import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 1000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE];
    public static int[] inOrder = new int[MAX_NODE + 1];
    public static String[] nodeName = new String[MAX_NODE + 1];
    public static HashMap<String, Integer> nodeMap = new HashMap<>();
    public static TreeSet<String>[] connectedSet = new TreeSet[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static PriorityQueue<String> ansPQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // num of node;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
            connectedSet[i] = new TreeSet<>();
            nodeName[i] = st.nextToken().toString();
            nodeMap.put(nodeName[i], i);
            ansPQ.add(nodeName[i]);
        }
        int m = Integer.parseInt(br.readLine()); // num of edge;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String c1 = st.nextToken().toString();
            String c2 = st.nextToken().toString();
            int start = nodeMap.get(c1);
            int end = nodeMap.get(c2);
            nodeList[end].add(start);
            inOrder[start]++;
        }

        ArrayList<Integer> rootList = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            if(inOrder[i] == 0){
                rootList.add(i);
                pq.add(i);
            }
        }

        System.out.println(rootList.size());
        for(int i = 0 ; i < rootList.size() ; i++){
            System.out.print(nodeName[rootList.get(i)] + " ");
        }
        System.out.println();

        while(!pq.isEmpty()){
            int curIdx = pq.poll();
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                inOrder[postIdx]--;
                if(inOrder[postIdx] == 0){
                    connectedSet[curIdx].add(nodeName[postIdx]);
                    pq.add(postIdx);
                }
            }
        }

        while(!ansPQ.isEmpty()){
            int idx = nodeMap.get(ansPQ.poll());
            System.out.print(nodeName[idx] + " " + connectedSet[idx].size() + " ");
            for(String s : connectedSet[idx]){
                System.out.print(s + " ");
            }
            System.out.println();
        }
        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print(nodeName[i] + " " + connectedSet[i].size() + " ");
        //     for(int idx : connectedSet[i]){
        //         System.out.print(nodeName[idx] + " ");
        //     }
        //     System.out.println();
        // }
    }
}