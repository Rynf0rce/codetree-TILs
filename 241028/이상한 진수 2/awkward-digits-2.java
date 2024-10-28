import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = String.valueOf(sc.nextInt());
        int val = 0;
        int loc = str.length();
        for(int i = str.length() - 1 ; i >= 0 ; i--){
            if(str.charAt(i) == '1'){
                val += Math.pow(2, str.length() - 1 - i);
            }
            else{
                loc = i;
            }
        }

        if(loc != str.length()){
            val += Math.pow(2, str.length() - 1 - loc);
        }
        else{
            val--;
        }
        System.out.print(val);
    }
}