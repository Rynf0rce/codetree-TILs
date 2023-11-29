import java.util.*;

public class Main {
    public static final int LOCATION_WIDTH = 100;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[LOCATION_WIDTH + 1];
        int num = sc.nextInt(), maxVal = 0;
        for(int i = 0 ; i < num ; i++){
            int location = sc.nextInt();
            char word = sc.next().charAt(0);
            arr[location] = word;
        }

        for(int i = 1 ; i < arr.length ; i++){
            int cntG = 0;
            int cntH = 0;
            for(int j = i ; j < arr.length ; j++){
                if(arr[i] == 'G' || arr[i] == 'H'){
                    if(arr[j] == 'G'){
                        cntG++;
                        if(cntG == cntH){
                            maxVal = Math.max(maxVal, (j - i));
                        }
                    }
                    else if(arr[j] == 'H'){
                        cntH++;
                        if(cntG == cntH){
                            maxVal = Math.max(maxVal, (j - i));
                        }
                    }   
                }
                else{
                    break;
                }
            }
        }
        System.out.println(maxVal);
    }
}