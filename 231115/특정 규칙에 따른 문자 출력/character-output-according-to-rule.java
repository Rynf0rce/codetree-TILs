import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), blankCnt = n, starCnt = 0;
        boolean triger = true;
        for(int i = 0 ; i < 2*n - 1 ; i++){
            if(i < n){
                blankCnt--;
            }
            else{
                blankCnt++;
                triger = false;
            }
            starCnt = n-blankCnt;
            if(triger){
                for(int j = 0 ; j < blankCnt  ; j++){
                System.out.print("  ");
                }
                for(int j = 0 ; j < starCnt ; j++ ){
                    System.out.print("@ ");
                }
            }
            else{
                for(int j = 0 ; j < starCnt  ; j++){
                    System.out.print("@ ");
                }
                for(int j = 0 ; j < blankCnt ; j++ ){
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}