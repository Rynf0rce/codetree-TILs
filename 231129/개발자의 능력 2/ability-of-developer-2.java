import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                for(int k = 0 ; k < arr.length ; k++){
                    for(int h = 0 ; h < arr.length ; h++){
                        if(i == j || i == k || i == h || j == k || j == h || k == h){
                            continue;
                        }
                        int[] tempArr = new int[]{(arr[i] + arr[j]), (arr[k] + arr[h]), (sum - arr[i] - arr[j] - arr[k] - arr[h])};
                        Arrays.sort(tempArr);
                        minVal = Math.min(minVal, tempArr[2]-tempArr[0]);
                    }
                }
            }
        }
        System.out.println(minVal);
    }
}