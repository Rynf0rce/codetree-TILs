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
        for(int i = 2 ; i < arr.length ; i++){
            if(arr[i] <= a+b && Plus_C_D - arr[i] >= arr[i]){
                c = arr[i];
                d = Plus_C_D - c;
                break;
            }
        }
        System.out.print(a + " " + b + " " + c + " " + d);
    }
}

// C <= A + B 라는 조건 때문에 세번째로 작은 숫자는 항상 C임.. int c = arr[2];
// int d = arr[n-1] - a - b - c;