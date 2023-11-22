import java.util.*;

// 문자열 배열도 마찬가지로 Arrays.sort로 정리 가능 역순은 Arrays.order(arr, Collections.reverseOrder());

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arr = new String[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}