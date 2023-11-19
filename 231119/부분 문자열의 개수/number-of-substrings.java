import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String target = sc.next();
        int cnt = 0;
        for(int i = 0 ; i < input.length() - 1 ; i++ ){
            if(input.substring(i, i + target.length()).equals(target)){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}