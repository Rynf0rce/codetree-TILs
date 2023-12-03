import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), maxVal = Integer.MIN_VALUE, currentVal = 0;
        char[] arr = sc.next().toCharArray();
        boolean triger = true;
        for(int i = 0 ; i < arr.length ; i++){
            char spell = arr[i];
            if(triger && spell == '1'){
                triger = false;
                currentVal++;
            }
            else if(!triger && spell == '0'){
                currentVal++;
            }
            else if(!triger && spell == '1'){
                currentVal++;
                maxVal = Math.max(maxVal, currentVal);
                currentVal = 0;
            }
        }
        System.out.println(maxVal / 2);
    }
}