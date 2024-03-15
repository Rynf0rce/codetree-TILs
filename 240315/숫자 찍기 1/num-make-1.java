import java.util.*;
public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[][] table = new int[MAX_LENGTH + 1][2 * (MAX_LENGTH - 1) + 1];

    public static void printNum(int num, int type){
        int cnt = 0;
        switch(type){
            case 1 :
                cnt = 1;
                for(int i = 0 ; i < num ; i++){
                    if(i % 2 == 0){
                        for(int j = 0 ; j <= i ; j++){
                            table[i][j] = cnt++;
                        }
                    }
                    else{
                        for(int j = i ; j >= 0 ; j--){
                            table[i][j] = cnt++;
                        }
                    }
                }
                
                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j < num ; j++){
                        if(table[i][j] == -1){
                            break;
                        }
                        System.out.print(table[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 2 :
                int center = num - 1;
                int length = num - 1;
                for(int i = 0 ; i < num ; i++){
                    for(int j = center - length ; j <= center + length ; j++){
                        table[i][j] = cnt;
                    }
                    cnt++;
                    length--;
                }

                for(int i = 0 ; i < num ; i++){
                    for(int j = 0 ; j < 2 * (num - 1) + 1 ; j++){
                        if(table[i][j] == -1){
                            System.out.print("  ");
                        }
                        else{
                            System.out.print(table[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 3 :
                for(int i = 1 ; i <= num / 2 + 1; i++){
                    for(int j = 1 ; j <= i ; j++){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }

                for(int i = num / 2 ; i >= 1 ; i--){
                    for(int j = 1 ; j <= i ; j++){
                        System.out.print(j + " ");
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
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < 2 * n - 1 ; j++){
                table[i][j] = -1;
            }
        }
        printNum(n, m);
    }
}