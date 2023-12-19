import java.util.*;

public class Main {
    public static final int MAX_RANGE = 20;
    public static int[][] arr2D = new int[MAX_RANGE][MAX_RANGE]; 
    public static int[][] ball2D = new int[MAX_RANGE][MAX_RANGE];
    public static int[] arrR = new int[]{-1, 0, 1, 0};
    public static int[] arrC = new int[]{0, 1, 0, -1};   
    public static int n;

    public static boolean inRange(int row, int column){
        return (row >= 0 && column >= 0 && row < n && column < n);
    }

    public static void conFnc(){
        int[][] temp = new int[MAX_RANGE][MAX_RANGE];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(ball2D[i][j] == 1){
                    int maxVal = 0;
                    int r = i;
                    int c = j;
                    for(int k = 0 ; k < arrR.length ; k++){
                        if(inRange(i + arrR[k],j + arrC[k]) && maxVal < arr2D[i + arrR[k]][j + arrC[k]]){
                            maxVal = arr2D[i + arrR[k]][j + arrC[k]];
                            r = i + arrR[k];
                            c = j + arrC[k];
                        }
                    }
                    temp[r][c]++;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(temp[i][j] > 1){
                    ball2D[i][j] = 0;
                }
                else{
                    ball2D[i][j] = temp[i][j];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt(), t = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < m ; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            ball2D[r - 1][c - 1]++;
        }
        
        while(t-- > 0){
            conFnc();
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(ball2D[i][j] == 1){
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}