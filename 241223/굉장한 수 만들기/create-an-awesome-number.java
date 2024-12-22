import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(minBoxes(n));
    }

    public static int minBoxes(int n) {
        // 삼각수 리스트 생성
        List<Integer> triangularNumbers = new ArrayList<>();
        int k = 1;

        // n 이하의 삼각수를 리스트에 추가
        while (true) {
            int triangle = k * (k + 1) / 2; // T_k = k(k+1)/2
            if (triangle > n) break;       // n보다 크면 종료
            triangularNumbers.add(triangle);
            k++;
        }

        // 역순 탐색하여 최소 개수 찾기
        int count = 0;
        for (int i = triangularNumbers.size() - 1; i >= 0; i--) {
            int triangle = triangularNumbers.get(i);
            while (n >= triangle) {
                n -= triangle;
                count++;
            }
            if (n == 0) break; // 목표를 달성하면 종료
        }

        return count;
    }
}
