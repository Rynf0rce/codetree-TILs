import java.util.*;

public class Main {
    public static int conFnc(int m){
        if(m % 2 == 0){
            return m / 2;
        }
        else{
            return m - 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        while(m>0){
            sum += arr[m - 1];
            m = conFnc(m);
            //System.out.println(sum + " " + m);
        }
        System.out.print(sum);
    }
}