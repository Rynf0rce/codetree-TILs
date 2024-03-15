import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int num = 1;
        for(int j = 0 ; j < m ; j++){
            for(int i = 0 ; i < n ; i++){
                table[i][j] = num++;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}