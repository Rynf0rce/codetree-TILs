import java.util.*;

public class Main {
    public static boolean interestingNum(int input){
        String str = String.valueOf(input);
        char[] arr = str.toCharArray();
        int[] chackArr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            chackArr[arr[i] - '0']++;
        }
        
        int sameCnt = 0, oneCnt = 0;
        for(int i = 0 ; i < chackArr.length ; i++){
            if(chackArr[i] == 1){
                oneCnt++;
            }
            else if(chackArr[i] > 1){
                sameCnt++;
            }
        }
        
        if(oneCnt == 1 && sameCnt == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), Y = sc.nextInt();
        int cnt = 0;
        for(int i = X ; i <= Y ; i++){
            if(interestingNum(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}