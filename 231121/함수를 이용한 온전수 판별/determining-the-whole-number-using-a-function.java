import java.util.*;

public class Main {
    public static boolean conFuc(int i){
        if(i%2 ==0){
            return false;
        }
        else if((i%10) == 5){
            return false;
        }
        else if(i%3 == 0 && i % 9 != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), cnt = 0;
        for(int i = a ; i <= b ; i++){
            if(conFuc(i)){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}