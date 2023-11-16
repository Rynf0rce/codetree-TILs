import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int[] count = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            try{
                arr[i] = sc.nextInt();
                if(arr[i] == 0){
                    break;
                }
                count[arr[i] / 10]++;

            }catch(NoSuchElementException e){
                break;
            }         
        }

        for(int i = 1; i < count.length ; i++){
            System.out.printf("%d - %d\n", i, count[i]);
        }


    }
}