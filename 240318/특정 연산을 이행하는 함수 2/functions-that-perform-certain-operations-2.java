import java.util.*;

public class Main {
    public static double[] arr = new double[3];
    public static double[] sortedArr = new double[3];

    public static int order(double num){
        int type = 0;
        for( ; type < 3 ; type++){
            if(num == sortedArr[type]){
                break;
            }
        }

        switch(type){
            case 0 :
                return (int)num;
            case 1 :
                return (int)Math.round(num);
            case 2 :
                if(num % 1 > 0){
                    return (int)num + 1;
                }
                else{
                    return (int)num;
                }
        }
        return -1;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextDouble();
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);

        for(int i = 0 ; i < 3 ; i++){
            System.out.print(order(arr[i]) + " ");
        }
    }
}