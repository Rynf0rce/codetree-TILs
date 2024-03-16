import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static char[][] table = new char[MAX_LENGTH][MAX_LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c = 'A';
        for(int j = n / 2 ; j >= 0 ; j--){
            int start = n / 2 - (n / 2 - j);
            int end = n / 2 + (n / 2 - j);
            for(int i = start ; i <= end ; i++){
                table[i][j] = c++;

                if(c > 'Z'){
                    c = 'A';
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= n / 2 ; j++){
                if(table[i][j] == '\0'){
                    break;
                }
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}