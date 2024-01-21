import java.util.*;

class point{
    int x;
    int y;

    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MAX_VALUE = 1000;
    public static point[] chkPointArr = new point[MAX_LENGTH];
    public static int[] leftArr = new int[MAX_LENGTH];
    public static int[] rightArr = new int[MAX_LENGTH];
    public static int N;

    public static int Manhattan(int preIdx, int postIdx){
        return Math.abs(chkPointArr[postIdx].x - chkPointArr[preIdx].x) + Math.abs(chkPointArr[postIdx].y - chkPointArr[preIdx].y);
    }

    public static int skipDistance(int skipIdx){
        return leftArr[skipIdx - 1] + Manhattan(skipIdx + 1, skipIdx - 1) + rightArr[skipIdx + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int minVal = MAX_VALUE * MAX_LENGTH + 1;
        for(int i = 0 ; i < N ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            chkPointArr[i] = new point(x, y);
        }

        for(int i = 1 ; i < N ; i++){
            leftArr[i] = leftArr[i - 1] + Manhattan(i, i - 1);
        }

        for(int i = N - 2 ; i >= 0 ; i--){
            rightArr[i] = rightArr[i + 1] + Manhattan(i + 1, i);
        }

        for(int i = 1 ; i < N - 1; i++){
            minVal = Math.min(minVal, skipDistance(i));
        }

        System.out.print(minVal);
    }
}