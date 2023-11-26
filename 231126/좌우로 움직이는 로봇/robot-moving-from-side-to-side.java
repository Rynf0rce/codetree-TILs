import java.util.*;

public class Main {
    public static final int distance = 1000001;
    
    public static int goFnc (char direction, int time){
        switch(direction){
            case 'L' :
                return time * -1;
            case 'R' :
                return time;
            default :
                return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), A_idx = 1, B_idx = 1;
        // test
        // N = 9;
        // M = 6;
        // int[] timeArr = new int[]{20,3,2,19,9,10,2,20,16,20,20,2,6,9,20};
        // char[] directionArr = new char[]{'R', 'R', 'R', 'L','L','R','L','L','R','L','L','L','L','R','R'};
        double[] arrA = new double[distance], arrB = new double[distance];
        for(int i = 0 ; i < N ; i++){ //int i = 0 ; i < N ; i++
            int time = /* timeArr[i]; */ sc.nextInt();
            char direction = /* directionArr[i]; */ sc.next().charAt(0); 
            for(int j = 0 ; j < time ; j++){
                arrA[A_idx] = arrA[A_idx-1] + goFnc(direction, 1);
                A_idx++;
            }
        }

        for(int i = 0 ; i < M ; i++){ // int i = 0 ; i < M ; i++
            int time = /* timeArr[i]; */ sc.nextInt();
            char direction = /* directionArr[i]; */ sc.next().charAt(0);
            for(int j = 0 ; j < time ; j++){
                arrB[B_idx] = arrB[B_idx-1] + goFnc(direction, 1);
                B_idx++;
            }
        }

        int maxCnt = Math.max(A_idx, B_idx);
        int minCnt = Math.min(A_idx, B_idx);

        if(maxCnt == A_idx){
            Arrays.fill(arrB, minCnt, maxCnt, arrB[minCnt-1]);
        }
        else{
            Arrays.fill(arrA, minCnt, maxCnt, arrA[minCnt-1]);
        }

        // for(int i = 1 ; i < maxCnt ; i++){
        //     System.out.print(arrA[i] + " ");
        // }
        // System.out.println();
        // for(int i = 1 ; i < maxCnt ; i++){
        //     System.out.print(arrB[i] + " ");
        // }
        //System.out.print(arrA[A_idx - 1] + " ");

        
        boolean triger = false;
        int cnt = 0;
        for(int i = 1 ; i < maxCnt ; i++){
            if(arrA[i] == arrB[i]){
                if(triger){
                    cnt++;
                    triger = false;
                    // System.out.println("이하" + i);
                }
            }
            else{
                triger = true;
            }

        }
        System.out.print(cnt);
    }
}