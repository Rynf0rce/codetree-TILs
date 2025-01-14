import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] xs, ys;
    
    // 압축 좌표
    static ArrayList<Integer> compX = new ArrayList<>();
    static ArrayList<Integer> compY = new ArrayList<>();
    static HashMap<Integer,Integer> mapX = new HashMap<>();
    static HashMap<Integer,Integer> mapY = new HashMap<>();
    
    // 블록(색칠된 칸) 여부 저장 (압축 좌표)
    // "row << 32 | col" 식으로 long에 담아 HashSet으로 관리
    static HashSet<Long> paintedSet;
    
    // 각 행(r)에 대한 "빈 칸 구간" 리스트
    // rowEmpty[r] = List of (startCol, endCol) in that row
    static ArrayList<int[]>[] rowEmpty;
    
    // 전체 빈 칸 구간(Interval)을 모아, 각 구간에 대해 id를 부여
    // intervalIdOfRow[r] = rowEmpty[r]에서 각 구간의 "전역 ID"
    static int[][] intervalIdOfRow;
    
    // 인접 리스트 (빈 칸 구간 간 그래프)
    static ArrayList<Integer>[] adj;
    
    // BFS 방문 여부
    static boolean[] visited;
    
    // 각 행의 빈 구간 찾을 때 사용할 임시 리스트
    static ArrayList<Integer>[] paintedColsInRow;
    
    // 방향 벡터
    static final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        xs = new int[N];
        ys = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }
        
        // --- (1) 좌표 압축 준비 ---
        // 블록 좌표 (x,y)에 대해, x±1, y±1까지도 후보에 넣음
        for(int i=0; i<N; i++){
            addCoord(compX, xs[i]);
            addCoord(compX, xs[i]-1);
            addCoord(compX, xs[i]+1);
            addCoord(compY, ys[i]);
            addCoord(compY, ys[i]-1);
            addCoord(compY, ys[i]+1);
        }
        removeOutOfRange(compX);
        removeOutOfRange(compY);
        
        // 정렬 + 중복 제거
        Collections.sort(compX);
        Collections.sort(compY);
        compX = unique(compX);
        compY = unique(compY);
        
        // 압축 맵핑
        for(int i=0; i<compX.size(); i++){
            mapX.put(compX.get(i), i);
        }
        for(int i=0; i<compY.size(); i++){
            mapY.put(compY.get(i), i);
        }
        
        int W = compX.size();
        int H = compY.size();
        
        // --- (2) 블록(색칠) 정보 set에 저장 ---
        paintedSet = new HashSet<>(N);
        for(int i=0; i<N; i++){
            int cx = mapX.get(xs[i]);
            int cy = mapY.get(ys[i]);
            long key = ((long)cy << 32) ^ (cx & 0xffffffffL);
            paintedSet.add(key);
        }
        
        // --- (3) 각 행마다 "그 행에서 블록인 열들" 정리 ---
        // H(압축 y범위)개 만큼 ArrayList 생성
        paintedColsInRow = new ArrayList[H];
        for(int r=0; r<H; r++){
            paintedColsInRow[r] = new ArrayList<>();
        }
        // 블록 정보 넣기
        for(long val : paintedSet){
            int r = (int)(val >>> 32);
            int c = (int)(val & 0xffffffffL);
            paintedColsInRow[r].add(c);
        }
        // 정렬
        for(int r=0; r<H; r++){
            Collections.sort(paintedColsInRow[r]);
        }
        
        // --- (4) 각 행의 "빈 칸 구간(Interval)" 찾기 ---
        // rowEmpty[r] = List of {startCol, endCol}
        rowEmpty = new ArrayList[H];
        intervalIdOfRow = new int[H][];
        
        // 전체 구간을 일렬로 나열했을 때의 ID (노드 번호)
        int totalIntervalCount = 0;
        
        for(int r=0; r<H; r++){
            rowEmpty[r] = new ArrayList<>();
            
            ArrayList<Integer> paintedCols = paintedColsInRow[r];
            // 만약 해당 행에 블록이 하나도 없으면, 통째로 [0..W-1]이 빈칸
            if(paintedCols.size() == 0){
                // 빈 칸 구간 하나
                rowEmpty[r].add(new int[]{0, W-1});
            } else {
                // 맨 앞 구간
                if(paintedCols.get(0) > 0){
                    rowEmpty[r].add(new int[]{0, paintedCols.get(0)-1});
                }
                // 중간 구간들
                for(int i=0; i<paintedCols.size()-1; i++){
                    int left = paintedCols.get(i);
                    int right = paintedCols.get(i+1);
                    if(right - left > 1){
                        // 사이에 빈 칸이 존재
                        rowEmpty[r].add(new int[]{left+1, right-1});
                    }
                }
                // 맨 끝 구간
                int last = paintedCols.get(paintedCols.size()-1);
                if(last < W-1){
                    rowEmpty[r].add(new int[]{last+1, W-1});
                }
            }
            // 이제 rowEmpty[r]에 이 행의 모든 빈칸 구간들이 들어감
            intervalIdOfRow[r] = new int[rowEmpty[r].size()];
            for(int i=0; i<rowEmpty[r].size(); i++){
                intervalIdOfRow[r][i] = totalIntervalCount++;
            }
        }
        
        // --- (5) 인접 리스트(빈칸 구간 그래프) 구성 ---
        adj = new ArrayList[totalIntervalCount];
        for(int i=0; i<totalIntervalCount; i++){
            adj[i] = new ArrayList<>();
        }
        
        // 같은 행 내부는 구간끼리 겹치지 않으므로, 상하 행만 체크
        for(int r=0; r<H-1; r++){
            ArrayList<int[]> rowA = rowEmpty[r];
            ArrayList<int[]> rowB = rowEmpty[r+1];
            int i=0, j=0;
            while(i<rowA.size() && j<rowB.size()){
                int sA = rowA.get(i)[0], eA = rowA.get(i)[1];
                int sB = rowB.get(j)[0], eB = rowB.get(j)[1];
                
                // 구간이 겹치는지 체크
                if(eA >= sB && eB >= sA){ 
                    // 겹침 => 인접
                    int idA = intervalIdOfRow[r][i];
                    int idB = intervalIdOfRow[r+1][j];
                    adj[idA].add(idB);
                    adj[idB].add(idA);
                }
                
                // 어떤 쪽 구간이 먼저 끝나는지에 따라 포인터 이동
                if(eA < eB) i++;
                else if(eA > eB) j++;
                else {
                    i++; 
                    j++;
                }
            }
        }
        
        // --- (6) BFS: 테두리(외부) 구간 찾기 ---
        visited = new boolean[totalIntervalCount];
        Queue<Integer> queue = new ArrayDeque<>();
        
        // (a) 위아래 행(r=0, r=H-1)의 모든 구간
        if(H > 0){
            for(int i=0; i<rowEmpty[0].size(); i++){
                int id = intervalIdOfRow[0][i];
                visited[id] = true;
                queue.offer(id);
            }
            for(int i=0; i<rowEmpty[H-1].size(); i++){
                int id = intervalIdOfRow[H-1][i];
                visited[id] = true;
                queue.offer(id);
            }
        }
        // (b) 각 행에서 col=0 또는 col=W-1과 닿아있는 구간
        for(int r=0; r<H; r++){
            for(int i=0; i<rowEmpty[r].size(); i++){
                int sC = rowEmpty[r].get(i)[0];
                int eC = rowEmpty[r].get(i)[1];
                // 좌우 테두리에 닿으면 BFS 시작
                if(sC == 0 || eC == W-1){
                    int id = intervalIdOfRow[r][i];
                    if(!visited[id]){
                        visited[id] = true;
                        queue.offer(id);
                    }
                }
            }
        }
        
        // 실제 BFS
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int nxt : adj[cur]){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    queue.offer(nxt);
                }
            }
        }
        
        // --- (7) 둘레 계산 ---
        // 방법: 모든 블록(색칠된 칸) 순회 → 상하좌우 체크
        //       (1) 범위 밖이면 +1
        //       (2) 범위 안인데 블록이 아니고, 해당 빈칸 구간이 BFS로 방문된(외부)라면 +1
        long perimeter = 0;
        
        for(long val : paintedSet){
            int r = (int)(val >>> 32);
            int c = (int)(val & 0xffffffffL);
            for(int[] d : DIR){
                int nr = r + d[0];
                int nc = c + d[1];
                // 압축 좌표 범위 밖
                if(nr < 0 || nr >= H || nc < 0 || nc >= W){
                    perimeter++;
                }
                else {
                    // 블록이 아니면 => 빈 칸
                    long neighborKey = ((long)nr << 32) ^ (nc & 0xffffffffL);
                    if(!paintedSet.contains(neighborKey)){
                        // 이 빈 칸이 "외부와 연결된" 칸인지 확인
                        // => rowEmpty[nr] 중에서 [sC..eC] 범위에 nc가 속하는 구간 찾기
                        int id = findIntervalId(rowEmpty[nr], intervalIdOfRow[nr], nc);
                        if(id >= 0 && visited[id]){
                            perimeter++;
                        }
                    }
                }
            }
        }
        
        System.out.println(perimeter);
    }
    
    // rowEmpty[r]의 intervals 중에서 col이 속하는 구간의 ID 찾기
    // (이진 탐색 사용 예시)
    static int findIntervalId(ArrayList<int[]> intervals, int[] intervalIds, int col){
        // intervals[k] = {sC, eC}, intervalIds[k] = 그 구간의 전역 id
        // col이 sC~eC 사이에 있으면 intervalIds[k] 반환
        // 없으면 -1
        int left=0, right=intervals.size()-1;
        while(left <= right){
            int mid = (left+right)/2;
            int sC = intervals.get(mid)[0];
            int eC = intervals.get(mid)[1];
            if(col < sC) {
                right = mid-1;
            } else if(col > eC){
                left = mid+1;
            } else {
                // sC <= col <= eC
                return intervalIds[mid];
            }
        }
        return -1;
    }
    
    // 좌표 범위 벗어난 값 제거
    static void removeOutOfRange(ArrayList<Integer> list){
        list.removeIf(x -> (x < 1 || x > 1_000_000));
    }
    
    // 리스트에 val 넣기 (중복 가능, 이후 unique()로 중복 제거)
    static void addCoord(ArrayList<Integer> list, int val){
        if(val >= 1 && val <= 1_000_000){
            list.add(val);
        }
    }
    
    // 정렬된 ArrayList에서 연속 중복 제거
    static ArrayList<Integer> unique(ArrayList<Integer> arr){
        if(arr.isEmpty()) return arr;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr.get(0));
        for(int i=1; i<arr.size(); i++){
            if(!Objects.equals(arr.get(i), arr.get(i-1))){
                res.add(arr.get(i));
            }
        }
        return res;
    }
}
