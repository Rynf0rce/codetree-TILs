import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean judge = true;
        int[] arr1 = new int[num], arr2 = new int[num];
        for(int i = 0 ; i < arr1.length ; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0 ; i < arr2.length ; i++){
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i = 0 ; i < arr1.length ; i++){
            if(arr1[i] != arr2[i]){
                judge = false;
                break;
            }
        }
        System.out.print(judge ? "Yes" : "No");
    }
}