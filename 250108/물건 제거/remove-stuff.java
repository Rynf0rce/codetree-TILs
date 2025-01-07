import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] machines;  // 기계 용량
    static int[] items;     // 물건 용량
    static boolean[][] canRemove; // canRemove[i][j] : 물건 i를 기계 j가 제거 가능한지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1) 입력 받기
        n = Integer.parseInt(br.readLine());
        machines = new int[n];
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                machines[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        k = Integer.parseInt(br.readLine());
        items = new int[k];
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                items[i] = Integer.parseInt(st.nextToken());
            }
        }

        // 2) 만약 어떤 물건의 용량이 모든 기계 용량보다 크다면 제거 불가 -> -1
        int maxMachine = Arrays.stream(machines).max().getAsInt();
        for (int item : items) {
            if (item > maxMachine) {
                System.out.println(-1);
                return;
            }
        }

        // 3) canRemove[][] 테이블 구성
        canRemove = new boolean[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (machines[j] >= items[i]) {
                    canRemove[i][j] = true; 
                }
            }
        }

        // 4) 각 물건이 제거되었는지 여부
        boolean[] removed = new boolean[k]; 
        int removedCount = 0;    // 제거 완료된 물건의 수
        int time = 0;           // 소요 시간(라운드)

        // 모든 물건을 제거할 때까지 반복
        while (removedCount < k) {
            // 이번 라운드에서의 최대 매칭을 수행
            // => 아직 제거되지 않은 아이템만 왼쪽 집합에, 모든 기계를 오른쪽 집합으로 보고 매칭
            //    매칭에 성공하면 해당 물건은 이번 라운드에 제거된 것.
            
            // matchR[j] = 오른쪽 정점 j(기계 j)에 매칭된 왼쪽 정점(물건) 번호 (없으면 -1)
            int[] matchR = new int[n];
            Arrays.fill(matchR, -1);

            int matchedThisRound = 0; // 이번 라운드에서 제거된 물건의 수

            // 아직 제거 안 된 물건들을 왼쪽 정점으로 순회하며 이분매칭 시도
            for (int itemIdx = 0; itemIdx < k; itemIdx++) {
                if (!removed[itemIdx]) {
                    // 방문 체크 배열: 한 번의 매칭 시도 중 같은 기계를 중복으로 보는 것 방지
                    boolean[] visited = new boolean[n];
                    if (dfsBipartite(itemIdx, visited, matchR)) {
                        // 매칭 성공 -> 이번 라운드에 제거된 물건
                        matchedThisRound++;
                    }
                }
            }

            // 만약 한 개도 매칭이 안 되었다면 => 더 이상 제거 불가능(무한루프 방지), 종료
            if (matchedThisRound == 0) {
                // 아직 안 제거된 물건이 남아있으므로 불가능
                System.out.println(-1);
                return;
            }

            // 매칭된 물건들은 제거로 처리
            // matchR[j]에 저장된 값(물건 번호)들은 모두 이번 라운드에 매칭된 것.
            for (int j = 0; j < n; j++) {
                int matchedItem = matchR[j];
                if (matchedItem != -1) {
                    removed[matchedItem] = true;
                }
            }
            
            removedCount += matchedThisRound;
            time++;
        }
        
        // 모두 제거 완료 -> time(라운드 수) 출력
        System.out.println(time);
    }

    /**
     * 이분 매칭을 위한 DFS 함수
     * @param itemIdx : 왼쪽 정점(물건) 번호
     * @param visited : 기계 방문 여부
     * @param matchR  : 기계에 매칭된 물건(왼쪽 정점) 번호
     * @return 매칭에 성공하면 true, 아니면 false
     */
    static boolean dfsBipartite(int itemIdx, boolean[] visited, int[] matchR) {
        // canRemove[itemIdx][j]가 true이고, 아직 매칭을 시도할 수 있는 기계 j를 탐색
        for (int j = 0; j < n; j++) {
            if (canRemove[itemIdx][j] && !visited[j]) {
                visited[j] = true;
                // 아직 기계 j에 매칭된 물건이 없거나, 
                // 매칭되어 있더라도 그 물건을 다른 기계로 재할당할 수 있다면(“재귀로 경로 열림”),
                // => j에 itemIdx를 매칭한다.
                if (matchR[j] == -1 || dfsBipartite(matchR[j], visited, matchR)) {
                    matchR[j] = itemIdx;
                    return true;
                }
            }
        }
        return false;
    }
}
