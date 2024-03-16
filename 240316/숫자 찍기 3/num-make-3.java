import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 29;
    public static int[][] table = new int[MAX_LENGTH][MAX_LENGTH];

    public static void printPascal(int num, int type){
        for(int i = 0 ; i < num ; i++){
            table[i][0] = 1;
            table[i][i] = 1;
        }

        for(int i = 0 ; i < num ; i++){
            for(int j = 0 ; j <= i ; j++){
                if(table[i][j] > 0){
                    continue;
                }

                table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
            }
        }
        
        switch(type){
            case 1 :
                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j <= i ; j++){
                        System.out.print(table[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 2 :
                int space = 0;
                for(int i = num - 1 ; i >= 0 ; i--){
                    for(int j = 0 ; j < space ; j++){
                        System.out.print(" ");
                    }
                    space++;
                    for(int j = 0 ; j <= i ; j++){
                        System.out.print(table[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 3 :
                int[][] rectTable = new int[MAX_LENGTH][MAX_LENGTH];
                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j < num ; j++){
                        rectTable[(num - 1) - j][(num - 1) - i] = table[i][j];
                    }
                }

                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j <= i ; j++){
                        System.out.print(rectTable[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printPascal(n, m);
    }
}