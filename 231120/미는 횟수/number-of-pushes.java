import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next(), B = sc.next(), trans = new String("");
        int n = -1;
        //A = new String("abcabc");
        //B = new String("cabcab");
        for(int i = 1 ; i <= A.length() ; i++){
            trans = new String("");
            trans = trans.concat(A.substring(A.length()-1, A.length()));
            trans = trans.concat(A.substring(0,A.length()-1));
            A = String.copyValueOf(trans.toCharArray());
            //System.out.println(A + " / " + B);
            //System.out.println(A.equals(B));
            if(A.equals(B)){
                n = i;
                break;
            }
        }
        System.out.print(n);
    }
}