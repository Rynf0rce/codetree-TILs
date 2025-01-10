import java.util.*;
import java.io.*;

public class Main {
    static int n,m;                     // N, M
    static Pair medusa, exit;          // 메두사 위치, 공원(출구) 위치
    static Warrior[] warriors;         // 전사들
    static int[][] board;              // 도로(0)/비도로(1)
    static Set<Integer>[][] wBoard;    // 각 좌표에 있는 전사들의 집합
    static int total;                  // 돌이 되지 않은(살아있는) 전사의 수
    static final Pair NO_POS = new Pair(-1,-1);
    
    static final int INT_MAX = Integer.MAX_VALUE;
    static int[][] dist;
    
    // 상하좌우
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    
    // 8방향(대각선 포함): 위(0시 방향)부터 시계방향
    static int[] dy2 = {-1,-1, 0, 1, 1, 1, 0, -1};
    static int[] dx2 = { 0, 1,  1, 1, 0,-1,-1, -1};
    
    static StringTokenizer st;
    static Sight WORST = new Sight(5, -1, null); // 비교용(시선 최악값)
    
    // 범위 검사
    static boolean OOB(int y,int x){
        return (y<0 || y>=n || x<0 || x>=n);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, M 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 메두사 집(Sr,Sc), 공원(Er,Ec)
        st = new StringTokenizer(br.readLine());
        medusa = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        exit   = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        // 전사들 입력
        warriors = new Warrior[m+1];
        st = new StringTokenizer(br.readLine());
        
        // wBoard 준비: 각 칸마다 전사 아이디를 저장할 수 있는 Set 생성
        wBoard = new HashSet[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                wBoard[i][j] = new HashSet<>();
            }
        }
        
        total = m;  // 아직 돌이 되지 않은 전사들의 총 수
        for(int id = 1; id <= m; id++){
            int wy = Integer.parseInt(st.nextToken());
            int wx = Integer.parseInt(st.nextToken());
            warriors[id] = new Warrior(id, wy, wx);
            // 해당 칸의 전사 집합에 이 전사의 id 추가
            wBoard[wy][wx].add(id);
        }
        
        // 마을 도로/비도로 정보
        board = new int[n][n];
        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++){
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 메두사의 최단거리 저장용
        dist = new int[n][n];
        
        // 정답 출력용
        StringBuilder sb = new StringBuilder();
        
        // 시뮬레이션 시작
        while(true){
            // 1) 메두사 이동
            medusa.move(); 
            
            // 메두사가 공원에 도달했다면 0 출력하고 종료
            if(medusa.isSame(exit.y, exit.x)){
                sb.append(0);
                break;
            }
            
            // 2) 메두사의 시선: 전사를 가장 많이 볼 수 있는 방향 찾음
            Sight best = findBestSight(); 
            
            // 3) 돌이 되지 않은 전사들 이동
            //    - best.visited[][] : 메두사의 시야(1=보이는 곳, 2=가려짐 등)
            int[] moved = moveAll(best.visited);
            
            // (moved[0], best.cnt, moved[1]) = (전사 이동 거리합, 돌이 된 전사 수, 메두사를 공격한 전사 수)
            sb.append(moved[0]).append(" ").append(best.cnt).append(" ").append(moved[1]).append('\n');
        }
        
        System.out.println(sb);
    }
    
    // 메두사 최단거리 갱신 후 한 칸 이동
    static class Pair{
        int y,x;
        public Pair(int y,int x){
            this.y = y;
            this.x = x;
        }
        
        public boolean isSame(int yy,int xx){
            return (y==yy && x==xx);
        }
        
        // 메두사의 이동
        public void move(){
            // dist를 모두 INT_MAX로 세팅
            for(int yy=0; yy<n; yy++){
                Arrays.fill(dist[yy], INT_MAX);
            }
            // exit에서 시작하여 메두사 위치까지 최단거리(bfs)
            bfs();
            
            // 다음 이동 위치
            Pair nxt = getNxtPos();
            if(nxt == NO_POS){
                // 공원으로 가는 길이 없다면 -1 출력 후 종료
                System.out.println(-1);
                System.exit(0);
            }
            
            // 메두사 좌표를 한 칸 옮긴다.
            this.y = nxt.y;
            this.x = nxt.x;
            
            // 옮긴 칸에 전사가 있으면, 그 전사들은 공격당해 사라진다.
            // (동일 칸에 여러 전사가 있을 수도 있음)
            if(!wBoard[y][x].isEmpty()){
                // 현재 칸에 있는 전사 전부 제거
                for(int wid : wBoard[y][x]){
                    warriors[wid].pair = NO_POS; // 전사 좌표 무효화
                    total--;
                }
                wBoard[y][x].clear();
            }
        }
        
        // 공원에서부터 BFS하여, 메두사가 있는 칸의 이웃들 중 dist가 가장 작은 칸으로 이동
        private void bfs(){
            Queue<Pair> q = new ArrayDeque<>();
            dist[exit.y][exit.x] = 0;
            q.add(exit);
            
            while(!q.isEmpty()){
                Pair cur = q.poll();
                // 메두사 위치에 도달하면 중단 가능(최단거리 찾았으니)
                if(cur.isSame(this.y,this.x)) break;
                
                for(int dir=0; dir<4; dir++){
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];
                    if(OOB(ny,nx)) continue;
                    if(dist[ny][nx] == INT_MAX && board[ny][nx]==0){
                        dist[ny][nx] = dist[cur.y][cur.x] + 1;
                        q.add(new Pair(ny,nx));
                    }
                }
            }
        }
        
        // 메두사 위치에서 4방향(상하좌우 중) dist가 가장 작은 칸(최단경로 우선순위)에 이동
        private Pair getNxtPos(){
            int y = this.y;
            int x = this.x;
            int distance = INT_MAX;
            Pair ret = NO_POS;
            
            // 문제 설명대로 상,하,좌,우 순서로 확인하여
            // dist가 가장 작은 곳을 골라 이동
            // dist값이 같아도 먼저 걸린 방향(상->하->좌->우) 우선
            int[] order = {0,1,2,3}; // 상하좌우
            for(int d : order){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(!OOB(ny,nx) && board[ny][nx]==0){
                    if(dist[ny][nx] < distance){
                        distance = dist[ny][nx];
                        ret = new Pair(ny,nx);
                    }
                }
            }
            return ret;
        }
    }
    
    // 전사를 가장 많이 볼 수 있는 시선 찾기
    static Sight findBestSight(){
        Sight ret = WORST;
        // dir= 0,2,4,6 (상하좌우를 8방향 중 짝수로 표현)
        for(int dir=0; dir<8; dir+=2){
            Sight s = makeSight(dir);
            if(s.isHigher(ret)){
                ret = s;
            }
        }
        return ret;
    }
    
    // 특정 방향(dir)으로 시야를 뻗쳤을 때, 돌이 되는 전사 수를 계산
    // visited[y][x] = 1이면 '메두사에게 보이는 곳', 2이면 '가려져서 보이지 않는 곳'
    static Sight makeSight(int dir){
        int[][] visited = new int[n][n];
        
        int sy = medusa.y;
        int sx = medusa.x;
        
        // BFS로 시야가 도달할 수 있는 지점을 모두 체크(대각 포함)
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(sy,sx,dir));
        visited[sy][sx] = 1;  // 시선이 미치는 곳을 1이라 표기
        
        // 메두사로부터 볼 수 있는 전사들의 좌표 목록
        ArrayList<Pair> wList = new ArrayList<>();
        
        while(!q.isEmpty()){
            Tuple cur = q.poll();
            // 좌우 45도 범위 => dir의 좌우 한 칸
            for(int nDir : getDirs(cur.dir)){
                int ny = cur.y + dy2[nDir];
                int nx = cur.x + dx2[nDir];
                if(OOB(ny,nx)) continue;
                if(visited[ny][nx]!=0) continue;
                
                // 전사가 있으면 일단 wList에 추가
                if(!wBoard[ny][nx].isEmpty()){
                    wList.add(new Pair(ny,nx));
                }
                // 계속 탐색 진행
                q.add(new Tuple(ny,nx,nDir));
                visited[ny][nx] = 1;
            }
        }
        // 시선의 시작점(메두사 위치)은 0으로 초기화(메두사 자신의 칸은 제외)
        visited[sy][sx] = 0;
        
        // 가려지는 처리(시야각에 들어온 전사들로 인해 뒤쪽 전사를 못 봄)
        for(Pair w : wList){
            int wy = w.y;
            int wx = w.x;
            if(visited[wy][wx] == 1){
                // 이 전사가 메두사의 시야를 가린다
                shadow(wy, wx, dir, visited);
            }
        }
        
        // 돌이 되는 전사 수 계산
        int cnt = 0;
        for(int i=1; i<=m; i++){
            // 이미 제거된 전사( NO_POS )는 패스
            if(warriors[i].pair == NO_POS) continue;
            
            int wy = warriors[i].pair.y;
            int wx = warriors[i].pair.x;
            // visited[...] == 1 이면 돌로 변한다.
            if(visited[wy][wx] == 1){
                cnt++;
            }
        }
        
        // dir을 문제의 상하좌우(0=상,1=하,2=좌,3=우) 기준으로 다시 매핑
        // 코드상 8방향 중 짝수 : 0(상),2(우상),4(우),6(우하),8(하), ...
        // 예시: dir=2 -> 실제론 '우상'이지만 문제에선 우(3)로 보고 있음
        // 편의를 위해 기존 코드를 따른 매핑
        int finalDir = dir;
        if(dir==2) finalDir = 3;  // 우
        else if(dir==4) finalDir = 1; // 하
        else if(dir==6) finalDir = 2; // 좌
        // 나머지 dir=0(상)은 그대로 0
        
        return new Sight(finalDir, cnt, visited);
    }
    
    // 시야에 걸린 전사들(visited=1)을 기준으로, 가려지는 영역(2) 마킹
    // 어떤 전사가 대각선 등 특정 방향으로 메두사와 일직선이라면, 그 뒤쪽 영역도 안 보임
    static void shadow(int y,int x, int dir, int[][] visited){
        // y,x가 메두사의 y나 x와 일치한다면(수직 또는 수평) => 한 줄로 쭉 가려버린다
        if(y == medusa.y || x == medusa.x){
            // y,x 에서 dir 방향으로 직선 쭉
            for(int dist=1; dist<=n; dist++){
                int ny = y + dy2[dir]*dist;
                int nx = x + dx2[dir]*dist;
                if(OOB(ny,nx)) break;
                visited[ny][nx] = 2;
            }
        }
        else {
            // 그렇지 않다면, 그 전사의 위치(y,x)를 중심으로 같은 방향으로 이어진 시야를 2로 바꾸기
            Queue<Pair> q = new ArrayDeque<>();
            q.add(new Pair(y,x));
            visited[y][x] = 2;
            
            while(!q.isEmpty()){
                Pair cur = q.poll();
                for(int nDir : getDirs(y, x, dir)){ 
                    int ny = cur.y + dy2[nDir];
                    int nx = cur.x + dx2[nDir];
                    if(OOB(ny,nx)) continue;
                    if(visited[ny][nx] == 1){
                        visited[ny][nx] = 2;
                        q.add(new Pair(ny,nx));
                    }
                }
            }
            
            // 마지막에 y,x만 다시 1로 되돌림(자신은 가리지 않는다)
            visited[y][x] = 1;
        }
    }
    
    // dir(8방향 중 짝수)일 때 좌우 45도까지 탐색
    // 예) dir=0(상)을 보고 있다면, 좌우 대각(7,1)도 탐색
    static int[] getDirs(int dir){
        if(dir % 2 == 0){
            return new int[]{(dir+7)%8, dir, (dir+1)%8};
        }
        return new int[]{dir};
    }
    
    // 전사 (wy,wx)가 어느 대각선 방향에 있느냐에 따라 shadow시 어떤 방향을 막을지 결정
    // 기존 코드 유지
    static int[] getDirs(int wy,int wx,int dir){
        // 메두사 (medusa.y, medusa.x)
        int my = medusa.y;
        int mx = medusa.x;
        
        if(dir==0){
            // 위 쪽(상)을 바라볼 때
            // 전사가 메두사보다 위왼쪽이라면(7,0), 위오른쪽이라면(0,1)
            if(wy < my && wx < mx) return new int[]{7,0};
            if(wy < my && wx > mx) return new int[]{0,1};
        }
        else if(dir==2){
            // 우쪽(대각 포함)
            if(wy < my && wx > mx) return new int[]{1,2};
            if(wy > my && wx > mx) return new int[]{2,3};
        }
        else if(dir==4){
            // 아래쪽(대각 포함)
            if(wy > my && wx > mx) return new int[]{3,4};
            if(wy > my && wx < mx) return new int[]{4,5};
        }
        else if(dir==6){
            // 왼쪽(대각 포함)
            if(wy > my && wx < mx) return new int[]{5,6};
            if(wy < my && wx < mx) return new int[]{6,7};
        }
        return new int[]{dir};
    }
    
    // 전사들 이동 (돌이 되지 않은 전사만)
    //  - 반환: [전사들이 이동한 총 거리합, 메두사를 공격한 전사 수]
    static int[] moveAll(int[][] visited){
        int distSum = 0;
        int attackerCnt = 0;
        
        for(int i=1; i<=m; i++){
            // 이미 NO_POS(돌이 되었거나 없어진) 전사는 패스
            if(warriors[i].pair == NO_POS) continue;
            
            Move move = warriors[i].move(visited);
            if(move.attack) attackerCnt++;
            distSum += move.dist;
        }
        return new int[]{distSum, attackerCnt};
    }
    
    // Sight: 메두사가 시선을 뻗었을 때(상하좌우), 돌이 되는 전사 수와 visited배열
    static class Sight{
        int dir;          // 방향(0=상,1=하,2=좌,3=우)
        int cnt;          // 돌로 변한 전사 수
        int[][] visited;  // 시야(1=보임,2=가려짐)
        
        public Sight(int dir,int cnt,int[][] visited){
            this.dir = dir;
            this.cnt = cnt;
            this.visited = visited;
        }
        
        // 두 Sight 비교: 돌이 되는 전사 수 많은 쪽 우선, 같다면 방향 우선순위(상->하->좌->우)
        public boolean isHigher(Sight o){
            if(this.cnt != o.cnt) return this.cnt > o.cnt;
            return this.dir < o.dir;  
        }
        
        public String toString(){
            return String.format("dir=%d, cnt=%d", dir,cnt);
        }
    }
    
    // BFS에서 사용할 튜플
    static class Tuple{
        int y,x,dir;
        public Tuple(int y,int x,int dir){
            this.y=y; this.x=x; this.dir=dir;
        }
    }
    
    // 전사 정보
    static class Warrior{
        int id;
        Pair pair;
        
        public Warrior(int id, int y, int x){
            this.id = id;
            this.pair = new Pair(y,x);
        }
        
        // 전사의 이동 로직
        //  - 메두사의 시야(visited[y][x] == 1)인 곳은 이동 불가
        //  - 첫 이동은 상하좌우 우선순위(메두사와의 맨해튼 거리 감소)
        //  - 두 번째 이동은 좌우상하 우선순위(문제에서 언급)
        //  - 이동 중 메두사 칸에 들어가면 공격 후 사라짐
        public Move move(int[][] visited){
            // 이미 돌이 된 경우(이번 턴에 못 움직임) => 이 로직 들어오기 전 걸러짐
            // 혹은 메두사 시야에 들어와서 돌이 된 경우(visited = 1) => 이동 안 함
            if(visited[pair.y][pair.x] == 1){
                return new Move(0,false);
            }
            
            // 첫 번째 이동
            int distance = getDistance(pair.y, pair.x, medusa.y, medusa.x);
            int direction = -1;
            // 상하좌우 순서
            int[] order1 = {0,1,2,3};  // 상하좌우
            for(int dir : order1){
                int ny = pair.y + dy[dir];
                int nx = pair.x + dx[dir];
                if(OOB(ny,nx)) continue;
                // 메두사의 시야(1)은 못 들어감
                if(visited[ny][nx] == 1) continue;
                int d = getDistance(ny,nx, medusa.y, medusa.x);
                if(d < distance){
                    distance = d;
                    direction = dir;
                }
            }
            // 첫 이동 못 하면 종료
            if(direction == -1){
                return new Move(0,false);
            }
            
            // 첫 이동 수행
            // 이동 전 기존 칸에서 전사 제거
            wBoard[pair.y][pair.x].remove(id);
            
            pair.y += dy[direction];
            pair.x += dx[direction];
            
            // 이동 후 메두사 칸이면 공격
            if(medusa.isSame(pair.y, pair.x)){
                // 전사 소멸
                warriors[id].pair = NO_POS;
                return new Move(1,true);
            }
            else {
                // 새 칸에 전사 id 추가
                wBoard[pair.y][pair.x].add(id);
            }
            
            // 두 번째 이동
            direction = -1;
            // 문제에 따르면 두 번째 이동은 좌우상하(2,3,0,1) 우선
            // 하지만 기존 코드에서는 for(int dir=2; dir<6; dir++) %4 => (2,3,0,1) 순
            int[] order2 = {2,3,0,1};  // 좌우상하
            distance = getDistance(pair.y, pair.x, medusa.y, medusa.x);
            
            for(int dir : order2){
                int ny = pair.y + dy[dir];
                int nx = pair.x + dx[dir];
                if(OOB(ny,nx)) continue;
                if(visited[ny][nx] == 1) continue;
                int d = getDistance(ny,nx, medusa.y, medusa.x);
                if(d < distance){
                    distance = d;
                    direction = dir;
                }
            }
            
            // 두 번째 이동도 못하면 (첫 이동만 성공)
            if(direction == -1){
                return new Move(1,false);
            }
            
            // 두 번째 이동 수행
            wBoard[pair.y][pair.x].remove(id);
            
            pair.y += dy[direction];
            pair.x += dx[direction];
            
            // 이동 후 메두사 칸이면 공격
            if(medusa.isSame(pair.y, pair.x)){
                warriors[id].pair = NO_POS;
                return new Move(2,true);
            }
            else {
                wBoard[pair.y][pair.x].add(id);
            }
            
            // 두 칸 모두 이동하고 메두사 못 만난 경우
            return new Move(2,false);
        }
        
        public String toString(){
            return String.format("%d:(%d,%d)", id, pair.y, pair.x);
        }
    }
    
    // 전사가 이동한 결과를 나타내는 클래스
    static class Move{
        int dist;     // 이동한 칸 수 (0~2)
        boolean attack;  // 이동 중 메두사를 공격했는지 여부
        
        public Move(int dist, boolean attack){
            this.dist = dist;
            this.attack = attack;
        }
    }
    
    // 맨해튼 거리
    static int getDistance(int y1,int x1, int y2,int x2){
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}
