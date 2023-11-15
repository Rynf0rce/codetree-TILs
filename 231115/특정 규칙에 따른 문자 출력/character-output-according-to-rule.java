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

/* n = int(input())
for i in range(1,n+1):
    print('  '*(n-i), end='')
    print('@ '*i, end='')
    print()
for j in range(n-1, 0, -1):
    print('@ '*j, end=' ')
    print() */

/* public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < n - i ; j++){
                System.out.print("  ");
            }
            for(int j = 0 ; j < i ; j++){
                System.out.print("@ ");
            }
            System.out.println();
        }
        for(int i = n-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                System.out.print("@ ");
            }
            for(int j = 0 ; j < n- i ; j++){
                System.out.print("  ");
            }
            System.out.println();
        }
    }
} */