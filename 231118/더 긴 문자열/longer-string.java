import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next(), str2 = sc.next();
        int length1 = str1.length(), length2 = str2.length();
        if(length1 > length2){
            System.out.print(str1 + " " + length1);
        }
        else if(length1 == length2){
            System.out.print("same");
        }
        else{
            System.out.print(str2 + " " + length2);
        }
    }
}