import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aMath = sc.nextInt();
        int aEnglish = sc.nextInt();
        int bMath = sc.nextInt();
        int bEnglish = sc.nextInt();
        char output = ' ';

        if(aMath > bMath){
            output = 'A';
        }
        else if(aMath == bMath && aEnglish > bEnglish){
            output = 'A';
        }
        else if(aMath == bMath && aEnglish < bEnglish){
            output = 'B';
        }
        else{
            output = 'B';
        }
        System.out.print(output);
    }
}