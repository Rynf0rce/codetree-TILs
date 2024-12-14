import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int maxScore = -1;
        
        for(int R1=0; R1<n; R1++){
            for(int R2=0; R2<n; R2++){
                if(R2 == R1) continue;
                for(int B=0; B<n; B++){
                    if(B == R1 || B == R2) continue;
                    int score = routeSum(arr, R1, B, R1, R2) + routeSum(arr, R2, B, R1, R2);
                    if(score > maxScore) {
                        maxScore = score;
                    }
                }
            }
        }
        
        System.out.println(maxScore);
    }
    
    // R에서 B로 이동하는 경로의 합을 구하되, 빨간점(R1,R2)은 제외, B는 포함
    // 경로 정의: R<=B 이면 [R..B], R>B이면 [B..R]
    // 시작점 R 자체는 빨간점이므로 제외해야 함.
    private static int routeSum(int[] arr, int R, int B, int R1, int R2) {
        int sum = 0;
        int start = Math.min(R,B);
        int end = Math.max(R,B);
        
        for(int i=start; i<=end; i++){
            // 빨간점 제외
            if(i == R1 || i == R2) continue;
            // R은 시작점이므로 제외(빨간점)
            if(i == R) continue;
            // B는 포함 (B는 빨간점 아니라고 가정)
            sum += arr[i];
        }
        
        return sum;
    }
}
