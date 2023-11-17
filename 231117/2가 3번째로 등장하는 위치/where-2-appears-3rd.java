import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfInt = sc.nextInt(), cnt = 0;
        int[] arr = new int[numOfInt];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 2){
                cnt++;
                if(cnt == 3){
                    System.out.print(i+1);
                    break;
                }
            }
        }
    }
}