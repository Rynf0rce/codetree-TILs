import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] capacities = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            capacities[i] = height * width; // 상자의 용량
        }

        Arrays.sort(capacities);
        for (int i = 0; i < k / 2; i++) {
            int temp = capacities[i];
            capacities[i] = capacities[k - 1 - i];
            capacities[k - 1 - i] = temp;
        }

        int itemsRemaining = n; 
        int boxesUsed = 0;      

        for (int capacity : capacities) {
            if (itemsRemaining <= 0) break; 
            itemsRemaining -= capacity;     
            boxesUsed++;                    
        }

        if (itemsRemaining > 0) {
            System.out.println("-1"); // 문제에서 불가능한 예제가 있으면 값 추가
        } else {
            System.out.println(boxesUsed);
        }
    }
}
