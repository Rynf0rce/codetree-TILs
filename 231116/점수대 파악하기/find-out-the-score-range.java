import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int[] count = new int[11];
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

        for(int i = count.length - 1; i > 0 ; i--){
            System.out.printf("%d - %d\n" , i*10, count[i]);
        }


    }
}