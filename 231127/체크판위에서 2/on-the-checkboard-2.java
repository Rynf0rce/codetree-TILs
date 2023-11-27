import java.util.*;

public class Main {
    public static char[][] arr2D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        arr2D = new char[R][C];
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                arr2D[i][j] = sc.next().charAt(0);
            }
        }

        char inputWord = arr2D[0][0];
        int cnt = 0;
        if(arr2D[0][0] != arr2D[R-1][C-1]){
            for(int i = 1 ; i < arr2D.length - 1 ; i++){
                for(int j = 1 ; j < arr2D[i].length - 1 ; j++){
                    for(int o = i + 1 ; o < arr2D.length - 1 ; o++){
                        for(int p = j + 1 ; p < arr2D[i].length - 1; p++){
                            if(inputWord != arr2D[i][j] && inputWord == arr2D[o][p]){
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        else{
            System.out.print(-1);
        }
        System.out.print(cnt);
        
    }
}