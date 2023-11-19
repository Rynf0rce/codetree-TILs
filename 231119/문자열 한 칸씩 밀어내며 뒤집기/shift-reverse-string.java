import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        char temp = ' ';
        int num = sc.nextInt(), task = 0;
        for(int i = 0 ; i < num ; i++){
            task = sc.nextInt();
            char[] workArr = new char[str.length()];
            switch(task){
                case 1 :
                    temp = arr[0];
                    for(int j = 0 ;  j < arr.length-1 ; j++){
                        workArr[j] = arr[j+1];
                    }
                    workArr[arr.length - 1] = temp;
                    arr = workArr.clone();
                    str = String.valueOf(arr);
                    break;
                case 2 :
                    temp = arr[arr.length -1];
                    for(int j = arr.length - 1 ;  j > 0 ; j--){
                        workArr[j] = arr[j-1];
                    }
                    workArr[0] = temp;
                    arr = workArr.clone();
                    str = String.valueOf(arr);
                    break;
                case 3 :
                    str = "";
                    for(int j = arr.length - 1 ; j >= 0 ; j--){
                        str += arr[j];
                    }
                    arr = str.toCharArray();
                    break;
            }
            System.out.println(str);
        }
    }
}