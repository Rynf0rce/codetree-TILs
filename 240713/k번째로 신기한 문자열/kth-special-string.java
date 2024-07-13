import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), order = sc.nextInt(), idx = 0;
        String target = sc.next(), input =" ";
        char[] targetArr = target.toCharArray(), inputArr;
        String[] arr = new String[100];
        for(int i = 0 ; i < num ; i++){
            input = sc.next();
            inputArr = input.toCharArray();
            if(Arrays.equals(Arrays.copyOf(inputArr, targetArr.length), targetArr)){
                arr[idx] = new String(input);
                idx++;
            }
        }
        arr = Arrays.copyOf(arr, idx);
        Arrays.sort(arr);
        System.out.print(arr[order-1]);
    }
}