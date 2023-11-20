import java.util.*;

public class Main {
    public static void printStr(int row, int column){
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < column ; j++){
                System.out.print('1');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        printStr(row, column);
    }
}