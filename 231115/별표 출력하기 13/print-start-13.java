import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int upperCnt = n, lowerCnt = 1;
        for(int i = 1; i <= 2*n ; i++){
            if(i % 2 == 0){
                for(int j = 0 ; j < lowerCnt ; j++){
                    System.out.print("* ");
                }
                lowerCnt++;
            }
            else{
                for(int j = 0 ; j < upperCnt ; j++){
                    System.out.print("* ");
                }
                upperCnt--;
            }
            System.out.println();
        }
            
    }
}