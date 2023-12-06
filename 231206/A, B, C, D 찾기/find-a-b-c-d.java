import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int a = arr[0], b = arr[1], Plus_C_D = arr[14] - a - b;
        int c = 0, d = 0;
        for(int i = arr.length - 2; i >= 0 ; i--){
            if(arr[i] != (Plus_C_D + a) && arr[i] != (Plus_C_D + b)){
                int temp = arr[i] - a - b;
                if(temp <= a + b){
                    c = temp;
                }
                else{
                    d = temp;
                }
            }
            if(a + b + c + d == arr[14]){
                System.out.print(a + " " + b + " " + c + " " + d);
                System.exit(0);
            }
        }
    }
}