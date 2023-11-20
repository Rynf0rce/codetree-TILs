import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        int cnt = 0;
        String[] strArr = new String[200];
        while(true){
            input = sc.next();
            if(input.equals("0"))
            {
                break;
            }
            else{
                strArr[cnt] = input;
            }
            cnt++;
        }
        System.out.println(cnt);
        for(int i = 0; i < cnt ; i = i+2){
            System.out.println(strArr[i]);
        }
    }
}