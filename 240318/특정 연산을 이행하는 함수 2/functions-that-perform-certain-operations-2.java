import java.util.*;

public class Main {
    public static double[] arr = new double[3];
    public static double[] sortedArr = new double[3];

    public static int order(int idx){
        switch(idx){
            case 0 :
                return (int)arr[0];
            case 1 :
                return (int)Math.round(arr[1]);
            case 2 :
                if(arr[2] % 1 > 0){
                    return (int)arr[2] + 1;
                }
                else{
                    return (int)arr[2];
                }
        }
        return -1;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextDouble();
        }

        Arrays.sort(arr);

        System.out.print(order(2) + " ");
        System.out.print(order(0) + " ");
        System.out.print(order(1));
    }
}