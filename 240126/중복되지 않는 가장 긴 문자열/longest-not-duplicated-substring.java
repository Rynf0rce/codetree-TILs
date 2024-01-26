import java.util.*;

public class Main {
    public static final int ALPHAPET_NUM = 26;
    public static int[] alphapet = new int[ALPHAPET_NUM];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();

        int j = -1;
        int output = 0;
        for(int i = 0 ; i < arr.length ; i++){
            while(j + 1 < arr.length){
                if(alphapet[arr[j + 1] - 'a'] == 0){
                    alphapet[arr[j + 1] - 'a']++;
                }
                else{
                    break;
                }
                j++;
            }
            output = Math.max(output, j - i + 1);
            alphapet[arr[i] - 'a']--;
        }

        System.out.println(output);
    }
}