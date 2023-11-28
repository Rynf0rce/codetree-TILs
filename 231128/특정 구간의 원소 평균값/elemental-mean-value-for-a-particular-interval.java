import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double[] arr = new double[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextDouble();
        }

        double sum = 0, cnt = 0;
        int output = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i ; j < arr.length ; j++){
                sum = 0;
                cnt = 0;
                for(int k = i ; k <= j ; k++){
                    sum += arr[k];
                    cnt++;
                }

                sum /= cnt;

                for(int k = i ; k <= j ; k++){
                    if(arr[k] == sum){
                        output++;
                        break;
                    }
                }
            }
        }
        System.out.println(output);
    }
}