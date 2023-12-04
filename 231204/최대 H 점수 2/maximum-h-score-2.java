import java.util.*;

public class Main {
    public static int[] arr;
    public static boolean Hpoint(int point ,int upCnt){
        int satifiedCnt = 0;
        int lackCnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= point){
                satifiedCnt++;
            }
            if(arr[i] + 1 == point){
                lackCnt++;
            }
        }

        if(lackCnt > upCnt){
            lackCnt = upCnt;
        }

        if(satifiedCnt + lackCnt >= point){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), L = sc.nextInt();
        arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        
        int output = 0;
        for(int i = 1 ; i <= 100 ; i++){
            if(Hpoint(i, L)){
                output = i;
            }
            else{
                break;
            }
        }
        System.out.println(output);
    }
}