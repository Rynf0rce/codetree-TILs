import java.util.*;

public class Main {
    public static int[] arr;
    public static int sortcost(){
        int cnt = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] < arr[i-1]){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        int cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next().charAt(0) - 'A';
        }
        while(true){
            int cost = sortcost();
            if(cost == 0){
                break;
            }
            else{
                cnt += cost;
            }
        }
        System.out.println(cnt);
    }
}