import java.util.*;
public class Main {
    public static int findWinner(int a, int b, int c){
        if(a == b && b == c){
            return 0;
        }
        else if(a == b){
            return 1;
        }
        else if(b == c){
            return 2;
        }
        else if(a == c){
            return 3;
        }
        else if(a > b && a > c){
            return 4;
        }
        else if(b > a && b > c){
            return 5;
        }
        else if(c > a && c > b){
            return 6;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, c = 0, cnt = 0, N = sc.nextInt();
        int winner = 1;
        for(int i = 0 ; i < N ; i++){
            char text = sc.next().charAt(0);
            if(text == 'A'){
                a += sc.nextInt();
            }
            else if(text == 'B'){
                b += sc.nextInt();
            }
            else{
                c += sc.nextInt();
            }
            int currentWinner = findWinner(a, b, c);
            if(winner != currentWinner){
                cnt++;
                winner = currentWinner;
            }
        }
        System.out.println(cnt);
    }
}