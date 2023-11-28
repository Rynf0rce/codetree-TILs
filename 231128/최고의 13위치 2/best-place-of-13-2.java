import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr2D = new int[N][N];
        for(int i = 0; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D.length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }
        int maxVal = Integer.MIN_VALUE, cnt = 0;
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length -2 ; j++){
                for(int o = i ; o < arr2D.length ; o++){
                    if(o == i){
                        for(int p = j + 3; p < arr2D.length -2 ; p++){
                            cnt = arr2D[i][j] + arr2D[i][j+1] + arr2D[i][j+2] + arr2D[o][p] + arr2D[o][p+1] + arr2D[o][p+2];
                            maxVal = Math.max(maxVal,cnt);
                        }
                    }
                    else{
                        for(int p = j ; p < arr2D.length-2 ; p++){
                            cnt = arr2D[i][j] + arr2D[i][j+1] + arr2D[i][j+2] + arr2D[o][p] + arr2D[o][p+1] + arr2D[o][p+2];
                            maxVal = Math.max(maxVal,cnt);
                        }
                    }
                    // System.out.println(cnt);
                }
            }
        }
        System.out.print(maxVal);
    }
}