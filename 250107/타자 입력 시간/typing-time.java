import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 맵핑: 각 문자 -> (row, col)
        // QWERTY 자판 그대로 3줄로 나눈다.
        Map<Character, int[]> posMap = new HashMap<>();
        String row0 = "qwertyuiop"; // row=0
        String row1 = "asdfghjkl";  // row=1
        String row2 = "zxcvbnm";    // row=2

        // row 0
        for(int col=0; col<row0.length(); col++){
            posMap.put(row0.charAt(col), new int[]{0,col});
        }
        // row 1
        for(int col=0; col<row1.length(); col++){
            posMap.put(row1.charAt(col), new int[]{1,col});
        }
        // row 2
        for(int col=0; col<row2.length(); col++){
            posMap.put(row2.charAt(col), new int[]{2,col});
        }

        // 왼손이 담당할 키, 오른손이 담당할 키
        Set<Character> leftSet = new HashSet<>(
            Arrays.asList('q','w','e','r','t','a','s','d','f','g','z','x','c','v')
        );
        // 오른손
        Set<Character> rightSet = new HashSet<>(
            Arrays.asList('y','u','i','o','p','h','j','k','l','b','n','m')
        );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char leftInit = st.nextToken().charAt(0);  // 왼손 초깃값
        char rightInit = st.nextToken().charAt(0); // 오른손 초깃값

        // 입력할 문자열
        String input = br.readLine().trim();

        // 왼손/오른손의 현재 (row, col) 좌표
        int[] leftPos = posMap.get(leftInit);
        int[] rightPos = posMap.get(rightInit);

        long totalTime = 0; // 걸린 시간

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // 어느 손으로 누를지 판별
            if (leftSet.contains(ch)) {
                // 왼손이 이동해야 함
                totalTime += distance(leftPos, posMap.get(ch)); // 이동 시간
                totalTime += 1; // 키 누르는 시간
                leftPos = posMap.get(ch);  // 왼손 위치 갱신
            } else {
                // 오른손이 이동
                totalTime += distance(rightPos, posMap.get(ch));
                totalTime += 1;
                rightPos = posMap.get(ch);
            }
        }

        System.out.println(totalTime);
    }

    // (r1,c1) -> (r2,c2)의 맨해튼 거리 계산
    private static int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
