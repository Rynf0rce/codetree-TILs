import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        str = "ba";

        char[] arr = str.toCharArray();
        char temp = ' ';
        int num = sc.nextInt(), task = 0;
        for(int i = 0 ; i < num ; i++){
            task = sc.nextInt();
            switch(task){
                case 1 :
                    temp = arr[0];
                    for(int j = 0 ;  j < arr.length-1 ; j++){
                        arr[j] = arr[j+1];
                    }
                    arr[arr.length - 1] = temp;
                    str = String.valueOf(arr);
                    break;
                case 2 :
                    temp = arr[arr.length -1];
                    for(int j = arr.length - 1 ;  j > 0 ; j--){
                        arr[j] = arr[j-1];
                    }
                    arr[0] = temp;
                    str = String.valueOf(arr);
                    break;
                case 3 :
                    str = "";
                    for(int j = arr.length - 1 ; j >= 0 ; j--){
                        str += arr[j];
                    }
                    break;
            }
            System.out.println(str);
        }
    }
}