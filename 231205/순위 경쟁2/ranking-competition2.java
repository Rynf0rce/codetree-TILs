import java.util.*;
public class Main {
    public static int findWinner(int a, int b){
        if(a > b){
            return 0;
        }
        else if(a == b){
            return 1;
        }
        else if(b > a){
            return 2;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, cnt = 0, N = sc.nextInt();
        int winner = 1;
        for(int i = 0 ; i < N ; i++){
            char c = sc.next().charAt(0);
            if(c == 'A'){
                a += sc.nextInt();
            }
            else{
                b += sc.nextInt();
            }
            int currentWinner = findWinner(a,b);
            if(winner != currentWinner){
                cnt++;
                winner = currentWinner;
            }
        }
        System.out.println(cnt);
    }
}