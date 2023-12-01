import java.util.*;

class lineInfo{
    int x1;
    int y1;
    int x2;
    int y2;
    boolean isolated;

    lineInfo(){}

    lineInfo(int x1, int y1, int x2, int y2, boolean isolated){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.isolated = isolated;
    }
}

public class Main {
    public static int counterClockwise(int x1, int y1, int x2, int y2, int x3, int y3){
        return (x2 - x1) * (y3 - y1) - (x3 -x1) * (y2 - y1);
    }

    public static boolean chackCross(lineInfo L1, lineInfo L2){
        int x1Tox3 = counterClockwise(L1.x1, L1.y1, L1.x2 , L1.y2, L2.x1, L2.y1);
        int x1Tox4 = counterClockwise(L1.x1, L1.y1, L1.x2 , L1.y2, L2.x2, L2.y2);
        int x3Tox1 = counterClockwise(L2.x1, L2.y1, L2.x2 , L2.y2, L1.x1, L1.y1);
        int x3Tox2 = counterClockwise(L2.x1, L2.y1, L2.x2 , L2.y2, L1.x2, L2.y2);

        if( ( (x1Tox3 >= 0 && x1Tox4 <= 0) || (x1Tox3 <= 0 && x1Tox4 >= 0) ) && ( (x3Tox1 >= 0 && x3Tox2 <= 0) || (x3Tox1 <= 0 && x3Tox2 >= 0) ) ){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        lineInfo[] arr = new lineInfo[N];
        for(int i = 0 ; i < arr.length ; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            arr[i] = new lineInfo(x1, 0, x2, 1, true);
        }
        
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(chackCross(arr[i], arr[j])){
                    arr[i].isolated = false;
                    arr[j].isolated = false;
                }
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].isolated){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

// 다른 방법으로는 겹치는 경우의 수를 정해서 작성 : 지정한 하나의 선분이 비교할 선분보다 x1이 크고, x2가 작은경우
// 지정한 하나의 선분이 비교할 선분보다 x1이 작고, x2가 큰 경우

/*
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        int ans = 0;

        // 다른 선분과 겹치지 않는 선분의 수를 구합니다.
        for(int i = 0; i < n; i++) {
            // i번째 선분이 다른 선분과 겹치지 않는지 확인합니다.

            boolean overlap = false;

            for(int j = 0; j < n; j++) {
                // 자기 자신은 제외합니다.
                if(j == i) continue;

                // x1이 큰 쪽 선분이 x2가 더 작다면 겹치게 됩니다.
                if((x1[i] <= x1[j] && x2[i] >= x2[j]) || (x1[i] >= x1[j] && x2[i] <= x2[j])) {
                    overlap = true;
                    break;
                }
            }

            // 겹치지 않았다면 정답의 개수에 하나를 추가합니다.
            if(overlap == false)
                ans++;
        }

        System.out.print(ans);
    }
}
*/
