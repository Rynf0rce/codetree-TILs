import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        int[] tempArr = new int[7];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length - 2; i++){
            for(int j = i + 1 ; j < arr.length - 1 ; j++){
                Arrays.fill(tempArr, 0);
                int a = 0;
                int b = 0;
                int c = 0;
                for(int k = j + 1 ; k < arr.length ; k++){
                    tempArr[0] = a = arr[i];
                    tempArr[1] = b = arr[j];
                    tempArr[2] = c = arr[k];
                    tempArr[3] = arr[i] + arr[j];
                    tempArr[4] = arr[j] + arr[k];
                    tempArr[5] = arr[k] + arr[i]; 
                    tempArr[6] = arr[i] + arr[j] + arr[k];

                    Arrays.sort(tempArr);
                    boolean triger = true;
                    for(int h = 0 ; h < tempArr.length ; h++){
                        if(arr[h] != tempArr[h]){
                            triger = false;
                            break;
                        }
                    }
                    if(triger){
                        System.out.print(a + " " + b + " " + c);
                        System.exit(0);
                    }
                }    
            }
        }
    }
}