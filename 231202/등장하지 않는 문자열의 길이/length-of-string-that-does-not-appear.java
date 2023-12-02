import java.util.*;

public class Main {
    public static char[] arr;
    public static int continuous(int i, int j){
        if(i < arr.length && j < arr.length){
            if(arr[i] == arr[j]){
                return continuous(i+1, j+1) + 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = sc.next().toCharArray();
        
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ;j++){
                maxVal = Math.max(maxVal, continuous(i,j));
            }
        }
        System.out.print(maxVal + 1);
    }
}