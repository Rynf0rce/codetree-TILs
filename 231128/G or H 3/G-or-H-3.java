import java.util.*;

public class Main {
    public static final int TOTAL_LOCATION = 10001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[TOTAL_LOCATION];
        Arrays.fill(arr, 'N');
        int n = sc.nextInt(), k = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int location = sc.nextInt();
            arr[location] = sc.next().charAt(0);
        }

        int sum = 0;
        for(int i = 1 ; i < TOTAL_LOCATION - k ; i++){
            sum = 0;
            for(int j = i ; j <= i + k ; j++){
                if(arr[j] == 'G'){
                    sum++;
                }
                else if(arr[j] == 'H'){
                    sum++;
                    sum++;
                }
            }
            maxVal = Math.max(maxVal, sum);
        }
        System.out.println(maxVal);
    }
}