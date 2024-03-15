import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 15;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];
    public static int n = -1;
    public static void makeTable(){
        for(int i = 0 ; i < n ; i++){
            table[i][i] = 2;
            table[i][0] = 2;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= i ; j++){
                if(table[i][j] > 0){
                    continue;
                }
                table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        makeTable();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= i ; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}