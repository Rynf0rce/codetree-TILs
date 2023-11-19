import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = sc.nextInt(), task = 0;
        for(int i = 0 ; i < num ; i++){
            task = sc.nextInt();
            switch(task){
                case 1 :
                    str = str.substring(1) + str.substring(0, 1);
                    break;
                case 2 :
                    str = str.substring(str.length()-1, str.length()) + str.substring(0, str.length()-1);
                    break;
                case 3 :
                    char[] arr = str.toCharArray();
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