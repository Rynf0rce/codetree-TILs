import java.util.*;

public class Main {
    public static final int MAX_NODES = 1000;
    public static ArrayList<Integer>[] graph = new ArrayList[MAX_NODES + 1];
    public static boolean[] visited = new boolean[MAX_NODES + 1];
    public static int n;
    public static int cnt = 0;

    public static void DFS(int curIdx){
        for(int i = 0 ; i < graph[curIdx].size() ; i++){
            int nextIdx = graph[curIdx].get(i);
            if(visited[nextIdx]){
                continue;
            }

            visited[nextIdx] = true;
            cnt++;
            DFS(nextIdx);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            int startIdx = sc.nextInt();
            int endIdx = sc.nextInt();

            graph[startIdx].add(endIdx);
            graph[endIdx].add(startIdx);
        }

        int rootIdx = 1;
        visited[rootIdx] = true;
        DFS(1);

        System.out.println(cnt);
    }
}

/*
import java.util.*;

public class Main {
    public static final int MAX_NODES = 1000;
    public static ArrayList<Integer>[] graph = new ArrayList[MAX_NODES + 1];
    public static boolean[] visited = new boolean[MAX_NODES + 1];
    public static int n;

    public static void DFS(int curIdx){
        for(int i = 0 ; i < graph[curIdx].size() ; i++){
            int nextIdx = graph[curIdx].get(i);
            if(visited[nextIdx]){
                continue;
            }

            visited[nextIdx] = true;
            DFS(nextIdx);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            int startIdx = sc.nextInt();
            int endIdx = sc.nextInt();

            graph[startIdx].add(endIdx);
            graph[endIdx].add(startIdx);
        }

        int rootIdx = 1;
        visited[rootIdx] = true;
        DFS(1);

        int output = 0;
        for(int i = 2 ; i <= n ; i++){
            if(visited[i]){
                output++;
            }
        }
        System.out.println(output);
    }
}
*/