import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next(), B = sc.next();
        int intA = 0, intB = 0, idx = 0, branch = 0;
        char[] arr = new char[18];
        
        for(int i = 0 ; i < A.length() ; i++){
            if(A.charAt(i) >= '0' && A.charAt(i) <= '9'){
                arr[idx] = A.charAt(i);
                idx++;
            }
        }

        A = String.copyValueOf(arr, 0, idx); // copyValueOf(array, startIndex, length)
        branch = idx;

        for(int i = 0 ; i < B.length() ; i++){
            if(B.charAt(i) >= '0' && B.charAt(i) <= '9'){
                arr[idx] = B.charAt(i);
                idx++;
            }
        }
        B = String.copyValueOf(arr, branch, idx - branch);

        System.out.print(Integer.parseInt(A) + Integer.parseInt(B)); // string to int
    }
}