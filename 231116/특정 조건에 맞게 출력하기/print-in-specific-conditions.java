import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int j = 0;
        for(int i = 0 ; i < arr.length ; i++){
            try{
                arr[i] = sc.nextInt();
            }
            catch(NoSuchElementException e){
                break;
            }
            j++;
        }
        for(int i = 0 ; i < j ; i++){
            if(arr[i] == 0){
                break;
            }
            else if(arr[i] % 2 == 0){
                System.out.print(arr[i] / 2 + " ");
            }
            else{
                System.out.print(arr[i] + 3 + " ");
            }
        }
    }
}