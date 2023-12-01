import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(), N = sc.nextInt();
        int[][] arr2D = new int[K][N];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }


        int pair = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(i == j){
                    continue;
                }
                int cnt = 0;
                for(int k = 0 ; k < arr2D.length ; k++){
                    int i_idx = -1;
                    int j_idx = -1;
                    for(int h = 0 ; h < arr2D[k].length ; h++){
                        if(arr2D[k][h] == i){
                            i_idx = h;
                        }
                        else if(arr2D[k][h] == j){
                            j_idx = h;
                        }
                    }
                    if(i_idx > j_idx){
                        cnt++;
                    }
                }
                if(cnt == arr2D.length){
                    pair++;
                }
            }
        }
        System.out.print(pair);
    }
}