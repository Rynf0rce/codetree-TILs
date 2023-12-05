import java.util.*;
public class Main {
    public static int findWinner(int a, int b, int c){
        if(a > b && a > c){
            return 0;
        }
        else if(b > a && b > c){
            return 1;
        }
        else if(c > a && c > b){
            return 2;
        }
        else if(a == b && b == c){
            return 3;
        }
        else if(a == b && b > c){
            return 4;
        }
        else if(b == c && c > a){
            return 5;
        }
        else if(a == c && c > b){
            return 6;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, c = 0, cnt = 0, N = sc.nextInt();
        int winner = -1;
        for(int i = 0 ; i < N ; i++){
            char text = sc.next().charAt(0);
            int point = sc.nextInt();
            if(point == 0){
                continue;
            }
            if(text == 'A'){
                a += point;
            }
            else if(text == 'B'){
                b += point;
            }
            else{
                c += point;
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