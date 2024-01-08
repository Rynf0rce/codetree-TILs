import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static char[] arr_A = new char[MAX_LENGTH + 1];
    public static char[] arr_B = new char[MAX_LENGTH + 1];

    public static int[][] DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
    public static String strA, strB;

    public static void initilize(){
        DP[1][1] = arr_A[1] == arr_B[1] ? 1 : 0;
        for(int i = 2 ; i <= strA.length() ; i++){
            if(arr_A[i] == arr_B[1]){
                DP[1][i] = 1;
            }
            else{
                DP[1][i] = DP[1][i - 1];
            }
        }

        for(int i = 2 ; i <= strB.length() ; i++){
            if(arr_B[i] == arr_A[1]){
                DP[i][1] = 1;
            }
            else{
                DP[i][1] = DP[i - 1][1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        strA = sc.next();
        strB = sc.next();
        
        for(int i = 1 ; i <= strA.length() ; i++){
            arr_A[i] = strA.charAt(i - 1);
        }

        for(int i = 1 ; i <= strB.length() ; i++){
            arr_B[i] = strB.charAt(i - 1);
        }

        initilize();

        for(int i = 2 ; i <= strB.length() ; i++){
            for(int j = 2 ; j <= strA.length() ; j++){
                if(arr_B[i] == arr_A[j]){
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                }
                else{
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }

        // for(int i = 1 ; i <= strB.length() ; i++){
        //     for(int j = 1 ; j <= strA.length() ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(DP[strB.length()][strA.length()]);
    }
}