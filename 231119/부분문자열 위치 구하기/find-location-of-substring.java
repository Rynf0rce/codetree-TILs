import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next(), compareStr = sc.next();
        int idx = -1;
        boolean triger = false;

        for(int i = 0 ; i < compareStr.length() ; i++){
            for(int j = 0; j < inputStr.length() ; j++){
                if(compareStr.charAt(i) == inputStr.charAt(j)){
                    if(!triger){
                        idx = j;
                        triger = true;
                    }
                    else if( (j - idx) == compareStr.length()){
                        break;
                    }
                }
                else{
                    triger = false;
                    idx = -1;
                }
            }
            if(triger){
                break;
            }
        }
        System.out.print(idx);
    }
}