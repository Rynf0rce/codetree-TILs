import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int maxVal = 0;
        for(int k = 0 ; k < arr.length ; k++){
            char temp = arr[k];
            if(temp == '1'){
                continue;
            }
            arr[k] = '1';
            int minVal = Integer.MAX_VALUE;
            for(int i = 0 ; i < arr.length ; i++){
                int distance = 0;
                if(arr[i] == '1'){
                    for(int j = i+1 ; j < arr.length ; j++){
                        if(arr[j] == '1'){
                            distance += (j - i);
                            minVal = Math.min(minVal, distance);
                            break;
                        }
                    }
                }
            }
            maxVal = Math.max(maxVal, minVal);
            arr[k] = temp;
        }
        System.out.println(maxVal);
    }
}