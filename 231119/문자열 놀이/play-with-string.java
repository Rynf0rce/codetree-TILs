import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int question = sc.nextInt();
        int method = 0, idx_1 = 0, idx_2 = 0;
        char char1 = ' ', char2 = ' ', temp = ' ';
        char[] arr = input.toCharArray();
        for(int i = 0 ; i < question ; i++){
            method = sc.nextInt();
            switch(method){
                case 1 :
                    idx_1 = sc.nextInt() - 1;
                    idx_2 = sc.nextInt() - 1;
                    temp = arr[idx_1];
                    arr[idx_1] = arr[idx_2];
                    arr[idx_2] = temp;
                    break;
                case 2 :
                    char1 = sc.next().charAt(0);
                    char2 = sc.next().charAt(0);
                    for(int j = 0 ; j < arr.length ; j++){
                        if(arr[j] == char1){
                            arr[j] = char2;
                        }
                    }
                    break;
            }
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}