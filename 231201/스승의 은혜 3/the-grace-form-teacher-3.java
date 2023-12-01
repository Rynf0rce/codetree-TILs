import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), B = sc.nextInt();
        int[][] arr2D = new int[N][2];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.nextInt();
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr2D.length; i++){
            int [][] tempArr2D = new int[arr2D.length][];
            for(int j = 0; j < arr2D.length; j++){
                tempArr2D[j] = arr2D[j].clone();
            }             
            tempArr2D[i][0] /= 2;
            Arrays.sort(tempArr2D, (a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
            
            int tempBudget = B;
            int cnt = 0;
            for(int j = 0 ; j < tempArr2D.length ; j++){
                for(int k = 0 ; k < tempArr2D[j].length ; k++){
                    tempBudget -= tempArr2D[j][k];
                }
                if(tempBudget < 0){
                    break;
                }
                else{
                    cnt++;
                }
            }
            maxVal = Math.max(maxVal, cnt);
        }
        System.out.println(maxVal);
    }
}