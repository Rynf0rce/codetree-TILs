import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 1000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE];
    public static int[] inOrder = new int[MAX_NODE + 1];
    public static char[] nodeName = new char[MAX_NODE + 1];
    public static HashMap<Character, Integer> nodeMap = new HashMap<>();
    public static TreeSet<Integer>[] connectedSet = new TreeSet[MAX_NODE + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // num of node;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
            connectedSet[i] = new TreeSet<>();
            nodeName[i] = st.nextToken().charAt(0);
            nodeMap.put(nodeName[i], i);
        }
        int m = Integer.parseInt(br.readLine()); // num of edge;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char c1 = st.nextToken().charAt(0);
            char c2 = st.nextToken().charAt(0);
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
                    connectedSet[curIdx].add(postIdx);
                    pq.add(postIdx);
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            System.out.print(nodeName[i] + " " + connectedSet[i].size() + " ");
            for(int idx : connectedSet[i]){
                System.out.print(nodeName[idx] + " ");
            }
            System.out.println();
        }
    }
}