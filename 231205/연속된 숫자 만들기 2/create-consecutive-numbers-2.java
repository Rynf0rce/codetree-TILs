import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        int[] arr = new int[]{n1, n2, n3};
        Arrays.sort(arr);
        int gap_1_2 = arr[1] - arr[0], gap_2_3 = arr[2] - arr[1];
        if(gap_1_2 == 1 && gap_1_2 == gap_2_3){
            System.out.print(0);
        }
        else if(gap_1_2 == 2 || gap_2_3 == 2){
            System.out.print(1);
        }
        else{
            System.out.print(2);
        }
    }
}