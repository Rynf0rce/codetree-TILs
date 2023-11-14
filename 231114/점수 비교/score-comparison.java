import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aMath = sc.nextInt();
        int aEnglish = sc.nextInt();
        int bMath = sc.nextInt();
        int bEnglish = sc.nextInt();
        int output = 0;

        if(aMath > bMath && aEnglish > bEnglish){
            output = 1;
        }
        System.out.print(output);
    }
}