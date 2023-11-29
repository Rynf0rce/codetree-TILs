import java.util.*;

public class Main {
    public static int N;
    public static boolean inRange(int[] arr, int a, int b, int c){
        int[] inputArr = new int[]{a,b,c};
        int cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = arr[i] - 2 ; j <= arr[i] + 2 ; j++ ){
                int temp = j;
                if(temp <= 0){
                    temp = N + j;
                }
                else if(temp > N){
                    temp -= N;
                }

                if(temp == inputArr[i]){
                    cnt++;
                    break;
                }
            }
        }
        return (cnt == 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[6];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                for(int h = 1 ; h <= N ; h++){
                    if(inRange(Arrays.copyOfRange(arr, 0 ,3), i,j,h) || inRange(Arrays.copyOfRange(arr, 3 ,arr.length), i,j,h)){
                        cnt++;
                    }
                    // if(inRange(Arrays.copyOfRange(arr, 0 ,3), i,j,h) && inRange(Arrays.copyOfRange(arr, 3 ,arr.length), i,j,h)){
                    //     cnt--;
                    // }
                }
            }
        }
        System.out.print(cnt);
    }
}