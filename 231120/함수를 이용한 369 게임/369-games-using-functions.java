import java.util.*;

public class Main {

    public static boolean judgeMultiple3(int num){
        if(num % 3 ==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean judge369(int num){
        char[] str = String.valueOf(num).toCharArray();
        boolean output = false;
        for(int i = 0; i < str.length ; i++){
            if( (str[i] - '0') % 3 == 0 ){
                output = true;
                break;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), cnt = 0;
        for(int i = a ; i <= b ; i++){
            if(judge369(i) || judgeMultiple3(i)){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}