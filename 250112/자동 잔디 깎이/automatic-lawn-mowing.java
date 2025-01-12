import java.util.*;
import java.io.*;

public class Main {
    static int N;
    // 매 초마다 (x,y)를 저장할 리스트
    // 최대 이동 거리 합이 N*10(=1000) 정도이므로 배열로 충분
    static ArrayList<int[]> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine().trim());

        // 시작 좌표 (0,0)로 가정
        int curX=0, curY=0;
        path.add(new int[]{curX, curY}); // t=0초 위치

        // 이동 기록을 받아서 매 초마다 위치를 기록
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int dist = Integer.parseInt(st.nextToken());
            // dist만큼 1초 단위로 이동
            for(int step=0; step<dist; step++){
                switch(dir){
                    case 'N': curY++; break;
                    case 'S': curY--; break;
                    case 'E': curX++; break;
                    case 'W': curX--; break;
                }
                path.add(new int[]{curX, curY});
            }
        }

        // 위치별로 방문 시각들을 저장
        // key: (x,y) -> 여러 시각
        Map<String, ArrayList<Integer>> posMap = new HashMap<>();
        for(int t=0; t<path.size(); t++){
            int x=path.get(t)[0];
            int y=path.get(t)[1];
            String key = x + "," + y;
            posMap.putIfAbsent(key, new ArrayList<>());
            posMap.get(key).add(t);
        }

        int minDiff = Integer.MAX_VALUE;
        boolean found = false;

        // 각 위치에 대해, 방문 시각 리스트를 꺼내 인접 방문 간 차이를 확인
        for(Map.Entry<String,ArrayList<Integer>> entry : posMap.entrySet()){
            ArrayList<Integer> times = entry.getValue();
            // 시각을 오름차순 정렬(이미 순차적으로 넣었으니 보통 정렬돼있지만 안전하게 정렬)
            Collections.sort(times);
            // 연속된 방문 시각 차이
            for(int i=0; i+1<times.size(); i++){
                int diff = times.get(i+1) - times.get(i);
                if(diff < minDiff){
                    minDiff = diff;
                }
                found = true;
            }
        }

        if(!found){
            // 한 번도 같은 위치를 2회 이상 방문 안 함 -> -1
            System.out.println(-1);
        } else {
            System.out.println(minDiff);
        }
    }
}
