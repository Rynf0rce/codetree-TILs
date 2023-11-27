import java.util.*;

public class Main {
    public static char[][] arr2D;

    public static int jump(char currentWord, int row, int column){
        int cnt = 0;
        for(int i = row + 1 ; i < arr2D.length - 1 ;i++){
            for(int j = column + 1 ; j < arr2D[i].length - 1 ; j++){
                if(arr2D[i][j] == currentWord){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), C = sc.nextInt();
        arr2D = new char[R][C];
        for(int i = 0 ; i < arr2D.length ; i++){
            for(int j = 0 ; j < arr2D[i].length ; j++){
                arr2D[i][j] = sc.next().charAt(0);
            }
        }
        int num = 0;
        char comText = arr2D[0][0];
        // System.out.print(jump(comText, 0, 0));
        for(int i = 1 ; i < arr2D.length -1 ; i++){
            for(int j = 1 ; j < arr2D.length - 1 ; j++){
                if(arr2D[i][j] != comText){
                    // System.out.println("i and j : " + i + " " + j);
                    num += jump(comText, i,j);
                }
            }
        }
        System.out.println(num);
    }
}