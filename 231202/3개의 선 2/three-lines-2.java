import java.util.*;

public class Main {
    public static final int RANGE = 10;
    public static int[][] arr2D;
    public static boolean connectedArr(int mode){
        int axis1 = 0;
        int axis2 = 0 ;
        int axis3 = 0;
        boolean[] chackArr = new boolean[arr2D.length];
        switch(mode){
            case 0 :
                axis1 = 0; axis2 = 0; axis3 = 0;
                break;
            case 1 :
                axis1 = 0 ; axis2 = 0 ; axis3 = 1;
                break;
            case 2 :
                axis1 = 0 ; axis2 = 1 ; axis3 = 1;
                break;
            case 3 :
                axis1 = 1 ; axis2 = 1 ; axis3 = 1;
                break;
        }
        for(int i = 0 ; i <= RANGE ; i++){
            for(int j = 0 ; j <= RANGE ; j++){
                for(int k = 0 ; k <= RANGE ; k++){
                    Arrays.fill(chackArr, false);
                    for(int h = 0 ; h < arr2D.length ; h++){
                        if(i == arr2D[h][axis1] || j == arr2D[h][axis2] || k == arr2D[h][axis3]){
                            chackArr[h] = true;
                        }
                    }
                    int cnt = 0;
                    for(int h = 0 ; h < chackArr.length ; h++){
                        if(chackArr[h]){
                            cnt++;
                        }
                    }
                    if(cnt == chackArr.length){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr2D = new int[N][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            arr2D[i][0] = sc.nextInt();
            arr2D[i][1] = sc.nextInt();
        }
            
        int output = 0;
        for(int i = 0 ; i <= 3 ; i++){
            if(connectedArr(i)){
                output = 1;
                break;
            }
        }
        System.out.print(output);
    }
}