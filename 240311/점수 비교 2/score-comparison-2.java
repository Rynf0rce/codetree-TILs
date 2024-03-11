import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A_Sci = sc.nextInt();
        int A_Soc = sc.nextInt();
        int B_Sci = sc.nextInt();
        int B_Soc = sc.nextInt();
        System.out.print((A_Sci > B_Sci && A_Soc > B_Soc) ? 1 : 0);
    }
}