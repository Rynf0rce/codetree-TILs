import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int[][] skyline = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            skyline[i][0] = x;
            skyline[i][1] = y;
        }

        Stack<Integer> stack = new Stack<>();
        long count = 0;  // 건물(직사각형) 최소 개수를 셀 변수

        for (int i = 0; i < n; i++) {
            int currentHeight = skyline[i][1];

            // 1) 스택 top이 현재 높이보다 크면 pop
            while (!stack.isEmpty() && stack.peek() > currentHeight) {
                int top = stack.pop();
                // 같은 높이가 연속으로 있을 수 있으므로, 연속 중복은 한 번만 카운트
                while (!stack.isEmpty() && stack.peek() == top) {
                    stack.pop();
                }
                count++; 
            }

            // 2) 스택이 비었거나 top < currentHeight이면 push
            //    단, currentHeight가 0인 경우는 건물이 없는(땅) 높이이므로 push하지 않는다.
            if (currentHeight > 0) {
                if (stack.isEmpty() || stack.peek() < currentHeight) {
                    stack.push(currentHeight);
                }
            }
            // 만약 stack.peek() == currentHeight 라면 건물 높이에 변화가 없으므로 아무것도 안 함
        }

        // 3) 모든 좌표 처리가 끝난 뒤, 스택에 남아있는 높이 정리
        while (!stack.isEmpty()) {
            int top = stack.pop();
            // 중복 제거
            while (!stack.isEmpty() && stack.peek() == top) {
                stack.pop();
            }
            count++;
        }

        System.out.println(count);
    }
}
