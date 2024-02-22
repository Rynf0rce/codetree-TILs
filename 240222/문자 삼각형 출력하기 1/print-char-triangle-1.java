import java.util.*;

public class Main {
    public static final int NUM_ALPHABET = 26;
    public static final int MAX_LENGTH = 100;
    public static char[][] table = new char[MAX_LENGTH][MAX_LENGTH];
    public static int n = -1;

    public static void draw(){
        int pivot = 0;
        char val = 'A';
        while(pivot < n){
            int row = pivot;
            int col = n - 1;
            while(row < n){
                table[row++][col--] = val;
                val++;
                if(val > 'Z'){
                    val = 'A';
                }
            }
            pivot++;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                table[i][j] = ' ';
            }
        }

        draw();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}