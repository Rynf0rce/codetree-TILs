import java.util.*;
public class Main {
    public static int[][][] volume = new int[2][4][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                for(int k = 0 ; k < 2 ; k++){
                    volume[i][j][k] = sc.nextInt(); 
                }
            }
        }

        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                System.out.print(volume[0][i][j] * volume[1][i][j] + " ");
            }
            System.out.println();
        }
    }
}