import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static char[][] table = new char[MAX_LENGTH][MAX_LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c = 'A';
        for(int j = n - 1 ; j >= 0 ; j--){
            for(int i = n - 1 ; i >= 0 ; i--){
                table[i][j] = c++;

                if(c > 'Z'){
                    c = 'A';
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}