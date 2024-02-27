import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] inOrder = new int[MAX_NODE + 1];
    public static Queue<Integer> q = new LinkedList<>();
    public static HashSet<Integer>[] nodeSet = new HashSet[MAX_NODE + 1];
    public static ArrayList<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= MAX_NODE; i++){
            nodeList[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int nodeIdx = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            nodeSet[nodeIdx] = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < num ; j++){
                int neededIdx = Integer.parseInt(st.nextToken());
                nodeSet[nodeIdx].add(neededIdx);
                nodeList[neededIdx].add(nodeIdx);
                inOrder[nodeIdx]++;
            }
        }

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < k ; i++){
            int inNode = Integer.parseInt(st.nextToken());
            q.add(inNode);
            ansList.add(inNode);
        }

        while(!q.isEmpty()){
            int curIdx = q.poll();
            
            for(int i = 0 ; i < nodeList[curIdx].size() ; i++){
                int postIdx = nodeList[curIdx].get(i);
                if(nodeSet[postIdx].contains(curIdx)){
                    inOrder[postIdx]--;
                    nodeSet[postIdx].remove(curIdx);

                    if(inOrder[postIdx] == 0){
                        q.add(postIdx);
                        if(!ansList.contains(postIdx)){
                            ansList.add(postIdx);
                        }
                    }
                }
            }
        }

        Collections.sort(ansList);
        System.out.println(ansList.size());
        for(int i : ansList){
            System.out.print(i + " ");
        }
    }
}