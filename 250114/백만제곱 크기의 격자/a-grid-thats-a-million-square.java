import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] xs, ys;            // 원본 좌표들을 저장
    static Set<Long> paintedSet;    // 색칠된 좌표를 (압축 전) 구분하기 위해 (x * 1_000_001L + y) 형태로 저장
    static boolean[][] painted;     // 압축 후, 색칠 여부
    static boolean[][] visited;     // 압축 후, 외부와 연결된 빈 칸 표시
    static ArrayList<Integer> compX = new ArrayList<>();
    static ArrayList<Integer> compY = new ArrayList<>();

    // 좌표 변환용 Map (원본 -> 압축 인덱스)
    static HashMap<Integer,Integer> mapX = new HashMap<>();
    static HashMap<Integer,Integer> mapY = new HashMap<>();

    // 4방향
    static final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        xs = new int[N];
        ys = new int[N];
        paintedSet = new HashSet<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xs[i] = x; 
            ys[i] = y;
        }

        // 1) 색칠된 칸들의 x,y 좌표와 그 인접좌표(±1) 수집
        for(int i=0; i<N; i++){
            int x = xs[i], y = ys[i];
            addCoord(compX, x);
            addCoord(compX, x-1);
            addCoord(compX, x+1);
            addCoord(compY, y);
            addCoord(compY, y-1);
            addCoord(compY, y+1);
        }

        // 범위를 벗어난 좌표는(0 이하 or 1,000,000 초과) 굳이 안 쓰겠다면 걸러도 되지만
        // 여기서는 음수나 0 이하도 넣지 않도록 필터링
        // (문제 조건: 1 <= x,y <= 1,000,000)
        removeOutOfRange(compX);
        removeOutOfRange(compY);

        // 2) 압축
        Collections.sort(compX);
        Collections.sort(compY);
        compX = unique(compX);
        compY = unique(compY);

        // 맵핑
        for(int i=0; i<compX.size(); i++){
            mapX.put(compX.get(i), i);
        }
        for(int i=0; i<compY.size(); i++){
            mapY.put(compY.get(i), i);
        }

        int w = compX.size();
        int h = compY.size();

        painted = new boolean[h][w]; 
        visited = new boolean[h][w];

        // 3) 색칠 여부 세팅
        for(int i=0; i<N; i++){
            int cx = mapX.get(xs[i]);
            int cy = mapY.get(ys[i]);
            painted[cy][cx] = true; 
        }

        // 4) 외부 빈 칸을 BFS
        // 압축 격자의 테두리에서, 빈 칸이면 queue에 넣고 확장
        Queue<int[]> queue = new ArrayDeque<>();

        // 윗변/아랫변
        for(int cx=0; cx<w; cx++){
            if(!painted[0][cx]) {
                visited[0][cx] = true;
                queue.offer(new int[]{0, cx});
            }
            if(!painted[h-1][cx]) {
                visited[h-1][cx] = true;
                queue.offer(new int[]{h-1, cx});
            }
        }
        // 왼변/오른변
        for(int cy=0; cy<h; cy++){
            if(!painted[cy][0]) {
                visited[cy][0] = true;
                queue.offer(new int[]{cy, 0});
            }
            if(!painted[cy][w-1]) {
                visited[cy][w-1] = true;
                queue.offer(new int[]{cy, w-1});
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            for(int[] d : DIR){
                int nr = r + d[0], nc = c + d[1];
                if(nr<0 || nr>=h || nc<0 || nc>=w) continue;
                if(!painted[nr][nc] && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // 5) 겉둘레 계산
        // "안에 색칠되지 않은 칸"과 맞닿은 변은 제외해야 하므로
        // "외부 빈 칸"과 맞닿은 변만 둘레로 센다.
        long perimeter = 0;
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                if(!painted[r][c]) continue;
                // 색칠된 칸
                for(int[] d : DIR){
                    int nr = r + d[0], nc = c + d[1];
                    // 격자 밖 => 외부로 열려있음 => 둘레 +1
                    if(nr<0 || nr>=h || nc<0 || nc>=w){
                        perimeter++;
                    } else {
                        // 빈 칸이고, 외부와 연결된 칸이면 +1
                        if(!painted[nr][nc] && visited[nr][nc]){
                            perimeter++;
                        }
                    }
                }
            }
        }

        System.out.println(perimeter);
    }

    // 좌표 저장 (범위 1..1,000,000에 들어올 때만)
    static void addCoord(ArrayList<Integer> list, int val){
        if(val >=1 && val <=1_000_000){
            list.add(val);
        }
    }

    // 범위를 벗어난 원소(1~1,000,000 밖) 제거
    static void removeOutOfRange(ArrayList<Integer> list){
        list.removeIf(x -> x<1 || x>1_000_000);
    }

    // 중복 제거
    static ArrayList<Integer> unique(ArrayList<Integer> arr){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr.get(0));
        for(int i=1; i<arr.size(); i++){
            if(!arr.get(i).equals(arr.get(i-1))){
                res.add(arr.get(i));
            }
        }
        return res;
    }
}
