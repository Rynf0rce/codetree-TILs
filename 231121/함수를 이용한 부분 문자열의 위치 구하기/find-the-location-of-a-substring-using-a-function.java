import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static String inputStr = sc.next();
    public static char[] inputArr = inputStr.toCharArray();
    public static String targetStr = sc.next();
    public static char[] targetArr = targetStr.toCharArray();

    public static int findIdx(char[] input, char[] target){
        int cnt = 0;
        for(int i = 0; i < input.length - target.length + 1 ; i++){
            cnt = 0;
            for(int j = 0 ; j < target.length ; j++){
                if(input[i + j] == target[j]){
                    cnt++;
                }
                else{
                    break;
                }
            }
            if(cnt == target.length){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int output = findIdx(inputArr, targetArr);
        System.out.print(output);
    }
}