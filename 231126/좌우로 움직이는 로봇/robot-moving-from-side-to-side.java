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
        double[] arrA = new double[distance], arrB = new double[distance];
        for(int i = 0 ; i < N ; i++){
            int time = sc.nextInt();
            char direction = sc.next().charAt(0); 
            for(int j = 0 ; j < time ; j++){
                arrA[A_idx] = arrA[A_idx-1] + goFnc(direction, 1);
                A_idx++;
            }
        }

        for(int i = 0 ; i < M ; i++){
            int time = sc.nextInt();
            char direction = sc.next().charAt(0);
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

        
        boolean triger = true;
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