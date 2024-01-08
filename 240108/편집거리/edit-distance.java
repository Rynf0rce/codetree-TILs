import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static char[] arr_A = new char[MAX_LENGTH + 1];
    public static char[] arr_B = new char[MAX_LENGTH + 1];
    public static int[][] DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1]; 
    public static String str_A, str_B;
    
    public static void initilize(){
        DP[0][0] = 0;

        for(int i = 1 ; i <= str_A.length() ; i++){
            DP[i][0] = DP[i - 1][0] + 1;
        }

        for(int i = 1 ; i <= str_B.length() ; i++){
            DP[0][i] = DP[0][i - 1] + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str_A = sc.next();
        str_B = sc.next();

        for(int i = 1 ; i <= str_A.length() ; i++){
            arr_A[i] = str_A.charAt(i - 1);
        }

        for(int i = 1 ; i <= str_B.length() ; i++){
            arr_B[i] = str_B.charAt(i - 1);
        }

        initilize();

        for(int i = 1 ; i <= str_A.length() ; i++){
            for(int j = 1 ; j <= str_B.length() ; j++){
                if(arr_A[i] == arr_B[j]){
                    DP[i][j] = DP[i - 1][j - 1];
                }
                else{
                    // add, remove, subtitution
                    DP[i][j] = Math.min(DP[i - 1][j - 1], Math.min(DP[i - 1][j], DP[i][j - 1])) + 1;
                }
            }
        }

        // for(int i = 0 ; i <= str_A.length() ; i++){
        //     for(int j = 0 ; j <= str_B.length() ; j++){
        //         System.out.print(DP[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(DP[str_A.length()][str_B.length()]);
    }
}