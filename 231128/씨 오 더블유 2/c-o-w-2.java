import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), cnt = 0;
        String str = sc.next();
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length -2 ; i++){
            for(int j = i + 1 ; j <arr.length -1 ; j++){
                for(int h = j + 1 ; h < arr.length ; h++){
                    if(arr[i] == 'C' && arr[j] == 'O' && arr[h] == 'W'){
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}