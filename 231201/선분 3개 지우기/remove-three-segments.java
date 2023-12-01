import java.util.*;

public class Main {
    public static final int RANGE_OF_MAX = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr2D = new int[n][2];
        int[] stateArr = new int[RANGE_OF_MAX + 1];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }
        
        int cnt = 0;
        boolean chack = true;
        for(int i = 0 ; i < arr2D.length - 2 ; i++){
            for(int j = i + 1 ; j < arr2D.length - 1 ;j++){
                for(int k = j + 1 ; k < arr2D.length ; k++){
                    Arrays.fill(stateArr, 0);
                    chack = true;
                    for(int h = 0 ; h < arr2D.length ; h++){
                        if(h == i || h == j || h == k){
                            continue;
                        }
                        else{
                            for(int p = arr2D[h][0] ; p <= arr2D[h][1] ; p++){
                                stateArr[p]++;
                            }
                        }
                    }

                    for(int h = 0 ; h < stateArr.length ; h++){
                        if(stateArr[h] > 1){
                            chack = false;
                            break;
                        }
                    }
                    if(chack){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}