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
            int [] tempArr = new int[arr2D.length];
            for(int j = 0; j < arr2D.length; j++){
                if(i == j){
                    tempArr[j] = arr2D[j][0] / 2 + arr2D[j][1];
                }
                else{
                    tempArr[j] = arr2D[j][0] + arr2D[j][1];
                }
            }             
            Arrays.sort(tempArr);

            int tempBudget = B;
            int cnt = 0;
            for(int j = 0 ; j < tempArr.length ; j++){
                tempBudget -= tempArr[j];
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