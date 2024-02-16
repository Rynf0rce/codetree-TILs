import java.util.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] parent = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static ArrayList<Integer> leafList = new ArrayList<>();
    public static int total_depth = 0;

    public static void traversal(int idx, int depth){
        boolean isLeaf = true;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int curIdx = nodeList[idx].get(i);
            if(!visited[curIdx]){
                isLeaf = false;
                visited[curIdx] = true;
                parent[curIdx] = idx;
                traversal(curIdx, depth + 1);
            }
        }
        if(isLeaf){
            leafList.add(idx);
            total_depth += depth;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i < n ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[1] = true;
        parent[1] = 1;
        traversal(1, 0);

        System.out.println(total_depth % 2);
    }
}