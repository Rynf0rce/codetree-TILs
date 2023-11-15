import java.util.*;

/* n = int(input())
for i in range(1,n+1):
    print('  '*(n-i), end='')
    print('@ '*i, end='')
    print()
for j in range(n-1, 0, -1):
    print('@ '*j, end=' ')
    print() */



public class Main {
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
}