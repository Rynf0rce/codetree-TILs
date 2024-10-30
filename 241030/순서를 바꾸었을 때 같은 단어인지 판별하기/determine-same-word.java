import java.util.*;
public class Main {
    public static final int LENGTH = 200;
    public static int[] A = new int[LENGTH];
    public static int[] B = new int[LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.next();
        String strB = sc.next();

        if(strA.length() != strB.length()){
            System.out.print("No");
            System.exit(0);
        }

        for(int i = 0 ; i < strA.length() ; i++){
            A['z' - strA.charAt(i)]++;
            B['z' - strB.charAt(i)]++;
        }

        boolean ans = true;
        for(int i = 0 ; i < LENGTH ; i++){
            if(A[i] != B[i]){
                ans = false;
                break;
            }
        }
        System.out.print(ans ? "Yes" : "No");
    }
}