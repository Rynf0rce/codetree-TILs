import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 1000;
    
    // 변수 선언
    public static int n, m;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    
    public static int[] dist = new int[MAX_N + 1];
    
    public static void dijkstra(int k) {
        // 그래프에 있는 모든 노드들에 대해
        // 초기값을 전부 아주 큰 값으로 설정
        // INT_MAX 그 자체로 설정하면
        // 후에 덧셈 진행시 overflow가 발생할 수도 있으므로
        // 적당히 큰 숫자로 적어줘야함에 유의!
        for(int i = 1; i <= n; i++)
            dist[i] = (int)1e9;
    
        // 시작위치에는 dist값을 0으로 설정
        dist[k] = 0;
    
        // visited 값을 초기화해줍니다.
        for(int i = 1; i <= n; i++)
            visited[i] = false;
    
        // O(|V|^2) 다익스트라 코드
        for(int i = 1; i <= n; i++) {
            // V개의 정점 중 
            // 아직 방문하지 않은 정점 중
            // dist값이 가장 작은 정점을 찾아줍니다.
            int minIndex = -1;
            for(int j = 1; j <= n; j++) {
                if(visited[j])
                    continue;
                
                if(minIndex == -1 || dist[minIndex] > dist[j])
                    minIndex = j;
            }
    
            // 최솟값에 해당하는 정점에 방문 표시를 진행합니다.
            visited[minIndex] = true;
    
            // 최솟값에 해당하는 정점에 연결된 간선들을 보며
            // 시작점으로부터의 최단거리 값을 갱신해줍니다.
            for(int j = 1; j <= n; j++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if(graph[minIndex][j] == 0)
                    continue;
    
                if(dist[j] > dist[minIndex] + graph[minIndex][j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프를 인접행렬로 표현
        // 양방향 그래프이므로 양쪽 다 표시해줍니다.
        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph[x][y] = z;
            graph[y][x] = z;
        }
        
        dijkstra(n);

        // 도착지에서 시작하여
        // 시작점이 나오기 전까지
        // 최단거리를 만족하는 경로 중
        // 가장 간선 번호가 작은 곳으로 이동합니다.
        int x = 1;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices.add(x);
        while(x != n) {
            for(int i = 1; i <= n; i++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if(graph[i][x] == 0)
                    continue;
                
                // 만약 b -> ... -> i -> x ... -> a로 
                // 실제 최단거리가 나올 수 있는 상황이었다면
                // i를 작은 번호부터 보고 있으므로
                // 바로 선택해줍니다.
                if(dist[i] + graph[i][x] == dist[x]) {
                    x = i;
                    break;
                }
            }
            vertices.add(x);
        }

        // A가 이동한 최단거리에서
        // 사전순으로 가장 앞선 경로상에 있는 
        // 간선을 제거합니다.
        for(int i = 0; i < vertices.size() - 1; i++) {
            int a = vertices.get(i);
            int b = vertices.get(i + 1);
            graph[a][b] = 0;
            graph[b][a] = 0;
        }

        // B가 이동했을 때의
        // 최단거리를 구합니다.
        dijkstra(1);

        int ans = dist[n];
        // 불가능하다면 -1을 출력합니다.
        if(ans == (int)1e9)
            ans = -1;

        System.out.print(ans);
    }
}