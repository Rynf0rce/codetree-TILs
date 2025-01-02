import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // 물건 번호는 최대 10까지이므로, 인덱스를 1~10으로 직접 사용 가능
        // -1로 초기화하여 "아직 관찰한 적 없음"을 표시
        int[] lastPos = new int[11];
        Arrays.fill(lastPos, -1);
        
        int totalMoves = 0; // 모든 물건이 확실히 이동한 횟수의 합
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int item = Integer.parseInt(st.nextToken());     // 물건 번호
            int position = Integer.parseInt(st.nextToken()); // 관찰된 위치 (0 or 1)
            
            // 아직 관찰된 적 없는 물건이면 위치만 저장
            if (lastPos[item] == -1) {
                lastPos[item] = position;
            } 
            // 관찰된 적 있는 물건이면 이전 위치와 비교
            else {
                if (lastPos[item] != position) {
                    totalMoves++;
                    lastPos[item] = position; // 위치 갱신
                }
            }
        }
        
        System.out.println(totalMoves);
    }
}
