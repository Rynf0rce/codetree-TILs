import java.util.*;

public class Main {
    public static int conFnc(int startpoint, int[] arr){
        int[] temparr = new int[arr.length];
        for(int i = 0 ; i < temparr.length ; i++){
            int currentidx = (startpoint + i + 1) % arr.length;
            temparr[i] = arr[currentidx];
        }

        int sum = 0;
        for(int i = 1 ; i < temparr.length ; i++){
            sum += i * temparr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            min = Math.min(min, conFnc(i, arr));
        }
        System.out.print(min);
    }
}