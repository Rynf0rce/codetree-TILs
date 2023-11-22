import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next(), str2 = sc.next();
        char[] arr1 = str1.toCharArray(), arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.print(Arrays.equals(arr1, arr2) ? "Yes" : "No");
    }
}