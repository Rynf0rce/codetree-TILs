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
                System.out.println(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}