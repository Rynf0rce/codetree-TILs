import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next(), str2 = sc.next(), str3 = sc.next();
        int length1 = str1.length(), length2 = str2.length(), length3 = str3.length();
        int sub_12 = Math.abs(length1 - length2), sub_13 = Math.abs(length1 - length3), sub_23 = Math.abs(length2 - length3);
        if(sub_12 >= sub_13 && sub_12 >= sub_23){
            System.out.print(sub_12);
        }
        else{
            if(sub_13 >= sub_23){
                System.out.print(sub_13);
            }
            else{
                System.out.print(sub_23);
            }
        }      
    }
}