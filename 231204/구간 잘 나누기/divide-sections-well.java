import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100 * 100;
    public static int[] arr;

    public static boolean conFnc(int maxVal, int boundaryNum){
        int cnt = 0;
        int currentVal = 0;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > maxVal || cnt > boundaryNum){
                return false;
            }

            currentVal += arr[i];

            if(currentVal > maxVal){
                currentVal = arr[i];
                cnt++;
            }
        }
        
        return (cnt <= boundaryNum); // 나누는 수가 딱 맞을 필요는 없음.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1 ; i <= MAX_RANGE ; i++){
            if(conFnc(i,m-1)){
                System.out.println(i);
                break;
            }
        }      
    }
}