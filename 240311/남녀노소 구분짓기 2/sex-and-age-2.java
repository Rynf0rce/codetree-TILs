import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gender = sc.nextInt();
        int age = sc.nextInt();
        char ans = ' ';
        if(gender == 0){
            if(age >= 19){
                ans = 'M';
            }
            else{
                ans = 'B';
            }
        }
        else{
            if(age >= 19){
                ans = 'W';
            }
            else{
                ans = 'G';
            }
        }
        System.out.print(ans);
    }
}