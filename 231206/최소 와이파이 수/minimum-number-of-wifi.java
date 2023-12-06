import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), totalWiFi = n / (2*m + 1);
        int[] arr = new int[n];
        int[] aroundArr = new int[n];
        boolean[] connnectArr = new boolean[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        if(n % (2*m + 1) != 0){
            totalWiFi++;
        }

        
        int cnt = 0;
        boolean triger = true;
        for(int i = 0 ; i < arr.length ; i++){
            cnt++;
            if(arr[i] == 1){
                triger = false;
            }

            if(cnt == 2*m + 1 || i == arr.length - 1){
                if(triger){
                    totalWiFi--;
                }
                triger = true;
                cnt = 0;
            }      
        }
        System.out.print(totalWiFi);
    }
}