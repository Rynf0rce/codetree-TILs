import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), target = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.print(arr[target-1]);
    }
}