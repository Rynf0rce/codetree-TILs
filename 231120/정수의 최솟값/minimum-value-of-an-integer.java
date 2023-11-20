import java.util.*;

public class Main {
    public static int compare(int n1, int n2, int n3){
        int minVal = Integer.MAX_VALUE;
        int[] arr = new int[]{n1, n2, n3};
        for(int i = 0 ; i < arr.length ; i++){
            if(minVal > arr[i]){
                minVal = arr[i];
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        System.out.print(compare(n1, n2, n3));
    }
}